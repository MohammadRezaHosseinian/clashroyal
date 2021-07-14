package code.dbms;

import code.exceptions.NotFoundUserException;
import code.users.User;

import java.sql.*;

public class UsersHandler {
    private User user;
    public UsersHandler(User user){
        this.user = user;
    }
    public UsersHandler(){

    }

    public void RegisterUserToDb() throws SQLException {
        Connection connection = Db.getSingleConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlCommand.INSERT_NEW_USER);
        preparedStatement.setString(1, user.getFname());
        preparedStatement.setString(2, user.getLname());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getPassword());
        preparedStatement.executeUpdate();

    }

    public User LoginUser(String usernameOrEmail, String password) throws SQLException, NotFoundUserException {
        Connection connection = Db.getSingleConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(String.format(SqlCommand.RETRIEVE_ONE_USER, usernameOrEmail, password, usernameOrEmail, password));
        if(rs.next()){
            String fname = rs.getString("firstname");
            String lname = rs.getString("lastname");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String user_password = rs.getString("password");
            return new User(fname, lname, username, email, user_password);
        }
        throw new NotFoundUserException(String.format("no any user with %s and %s ", usernameOrEmail, password));
    }
}
