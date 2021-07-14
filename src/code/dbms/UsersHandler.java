package code.dbms;

import code.controllers.Defaults;
import code.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersHandler {
    private User user;
    public UsersHandler(User user){
        this.user = user;
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
}
