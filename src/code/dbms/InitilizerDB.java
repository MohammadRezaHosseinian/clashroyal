package code.dbms;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitilizerDB {

    private static void initUsersTable(){
        try {
            Connection connection = Db.getSingleConnection();
            Statement stat = connection.createStatement();
            stat.execute(SqlCommand.CREATE_USERS_TABLE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // for each table in db : must init table inside method
    public static void init(){
        initUsersTable();
    }
}
