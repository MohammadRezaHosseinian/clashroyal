package code.controllers;

import code.dbms.UsersHandler;
import code.exceptions.NotFoundUserException;
import code.users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController {

    @FXML
    private AnchorPane parent;
    @FXML
    private Label gotoRegister;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginBtn;
    @FXML
    private TextField usernameOrEmail;


    @FXML
    public void initialize() {
        BackgroundImage bi = new BackgroundImage(new Image("res//drawable//back.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT
                );
        this.parent.setBackground(new Background(bi));
        gotoRegister.setCursor(Cursor.CROSSHAIR);
    }
    public void loginHandler(ActionEvent actionEvent) {
        String usernameOrEmailText = usernameOrEmail.getText();
        String passwordText = password.getText();
        UsersHandler handler = new UsersHandler();
        try {
            User user = handler.LoginUser(usernameOrEmailText, passwordText);
            System.out.println(String.format("user %s login succesful", user.getEmail()));
        } catch (SQLException | NotFoundUserException throwables) {
            throwables.printStackTrace();
        }

    }
    
    public void gotoRegisterClicked(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) this.gotoRegister.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/register.fxml"));
        Parent parent = loader.load();
        stage.setScene(new Scene(parent));
    }
}
