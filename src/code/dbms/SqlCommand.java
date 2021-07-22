package code.dbms;

/*
 **
 * this class helps for handle SQL commands
 **
 */

public class SqlCommand {
    private final String DB_NAME = "";
    private static final String USER_TABLE_NAME = "USERS";

    public static final String INSERT_NEW_USER = String.format("""
            INSERT INTO %s (firstname,lastname,username,email,password) VALUES (?,?,?,?,?);
                    """, USER_TABLE_NAME);
    public static final String CREATE_USERS_TABLE = String.format("""
            CREATE TABLE IF NOT EXISTS %s(id integer PRIMARY KEY,
            firstname text,
            lastname text,
            username text UNIQUE NOT NULL,
            email text UNIQUE NOT NULL,
            password text NOT NULL);
            """, USER_TABLE_NAME);
    public static final String RETRIEVE_ONE_USER = """
            SELECT * FROM USERS WHERE ((username='%s' AND password='%s') OR (email='%s' AND password='%s')) LIMIT 1;
            """;

}
