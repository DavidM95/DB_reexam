package DAL;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnect {

    void createConnection() throws SQLException;
    Connection getConnection();
    void closeConnection() throws SQLException;
}
