package code.controllers;

/*
 **
 * this class helps for handle register page
 **
 */

import code.dbms.UsersHandler;
import code.exceptions.InvalidConfirmPasswordException;
import code.exceptions.InvalidEmailException;
import code.exceptions.InvalidLengthField;
import code.exceptions.InvalidPasswordPatternException;
import code.users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterController {
    @FXML
    public TextField lname;
    @FXML
    public ImageView fnameImage;
    @FXML
    public ImageView lnameImage;
    @FXML
    public ImageView usernameImage;
    @FXML
    public ImageView emailImage;
    @FXML
    public ImageView passwordImage;
    @FXML
    public ImageView confirmPasswordImage;
    @FXML
    public Label errorMessage;
    @FXML
    public AnchorPane parent;
    @FXML
    private TextField fname;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Button registerBtn;


    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,40}$");

    @FXML
    public void initialize() {
        BackgroundImage bi = new BackgroundImage(new Image("res//drawable//back.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.parent.setBackground(new Background(bi));
    }

    private boolean isValidForm(){
        try {
            validateFirstname();
            validateLastname();
            validateUsername();
            validateEmail();
            validatePassword();
            validateConfirmPassword();
        } catch (Exception ex) {
            this.errorMessage.setText(ex.getMessage());
            return false;
        }
        return true;
    }

    private void validateFirstname() throws InvalidLengthField {
        if(fname.getText().length() < Defaults.MINIMUM_USERS_LEN)
            throw new InvalidLengthField(String.format(Defaults.INVALID_LEN_MESSAGE, "firstname", Defaults.MINIMUM_USERS_LEN));
    }

    private void validateLastname() throws InvalidLengthField {
        if(lname.getText().length() < Defaults.MINIMUM_USERS_LEN)
            throw new InvalidLengthField(String.format(Defaults.INVALID_LEN_MESSAGE, "lastname", Defaults.MINIMUM_USERS_LEN));
    }

    private void validateUsername() throws InvalidLengthField {
        if(username.getText().length() < Defaults.MINIMUM_USERS_LEN)
            throw new InvalidLengthField(String.format(Defaults.INVALID_LEN_MESSAGE, "username", Defaults.MINIMUM_USERS_LEN));
    }

    private void validateEmail() throws InvalidEmailException {
        String emailText = email.getText();
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailText);
        if(! matcher.find())
            throw new InvalidEmailException(Defaults.INVALID_EMAIL_MESSAGE);
    }

    private void validatePassword() throws InvalidLengthField, InvalidPasswordPatternException {
        String passwordText = password.getText();
        if (passwordText.length() < Defaults.MINIMUM_PASSWORD_LEN || passwordText.length() > Defaults.MAXIMUN_PASSWORD_LEN){
            throw new InvalidLengthField(Defaults.INVALID_LEN_PASSWORD_MESSAGE);
        }
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(passwordText);
        if(! matcher.find()){
            throw new InvalidPasswordPatternException(Defaults.INVALID_PASSWORD_PATTERN_MESSAGE);
        }
    }

    private void validateConfirmPassword() throws InvalidConfirmPasswordException {
        if(!confirmPassword.getText().equals(password.getText())){
            throw new InvalidConfirmPasswordException(Defaults.INVALID_CONFIRM_PASSWORD_MESSAGE);
        }

    }

    public void fnameTyped(KeyEvent keyEvent) {
        try {
            validateFirstname();
            fnameImage.setImage(new Image(Defaults.VALID_IMAGE_URI));
        } catch (InvalidLengthField invalidLengthField) {
            fnameImage.setImage(new Image(Defaults.INVALID_IMAGE_URI));
        }
    }

    public void lnameTyped(KeyEvent keyEvent) {
        try {
            validateLastname();
            lnameImage.setImage(new Image(Defaults.VALID_IMAGE_URI));
        } catch (InvalidLengthField invalidLengthField) {
            lnameImage.setImage(new Image(Defaults.INVALID_IMAGE_URI));
        }
    }

    public void usernameTyped(KeyEvent keyEvent) {
        try {
            validateUsername();
            usernameImage.setImage(new Image(Defaults.VALID_IMAGE_URI));
        } catch (InvalidLengthField invalidLengthField) {
            usernameImage.setImage(new Image(Defaults.INVALID_IMAGE_URI));
        }
    }

    public void emailTyped(KeyEvent keyEvent) {
        try {
            validateEmail();
            emailImage.setImage(new Image(Defaults.VALID_IMAGE_URI));
        } catch (InvalidEmailException e) {
            emailImage.setImage(new Image(Defaults.INVALID_IMAGE_URI));
        }
    }

    public void passwordTyped(KeyEvent keyEvent) {
        try {
            validatePassword();
            passwordImage.setImage(new Image(Defaults.VALID_IMAGE_URI));
        } catch (InvalidLengthField | InvalidPasswordPatternException invalidLengthField) {
            passwordImage.setImage(new Image(Defaults.INVALID_IMAGE_URI));
        }
    }

    public void confirmPasswordTyped(KeyEvent keyEvent) {
        try {
            validateConfirmPassword();
            confirmPasswordImage.setImage(new Image(Defaults.VALID_IMAGE_URI));
        } catch (InvalidConfirmPasswordException e) {
           confirmPasswordImage.setImage(new Image(Defaults.INVALID_IMAGE_URI));
        }
    }

    public void onSubmit(ActionEvent actionEvent) {
        if(isValidForm()){
            User user = new User(
                    fname.getText(),
                    lname.getText(),
                    username.getText(),
                    email.getText(),
                    password.getText()
            );
            UsersHandler handler = new UsersHandler(user);
            try {
                handler.RegisterUserToDb();
                errorMessage.setTextFill(Color.web("#7f7"));
                errorMessage.setText(Defaults.REGISTER_SUCCESS_MESSAGE);
                registerBtn.setDisable(true);
                Stage stage = (Stage) this.registerBtn.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/menu.fxml"));
                Parent parent = loader.load();
                MenuController controller = loader.getController();
                controller.setUser(user);
                stage.setScene(new Scene(parent, 1200, 600));
            } catch (SQLException | IOException throwables) {
                errorMessage.setText(throwables.getMessage());
            }

        }
    }
}
