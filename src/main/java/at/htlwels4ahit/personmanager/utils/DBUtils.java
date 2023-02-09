package at.htlwels4ahit.personmanager.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Objects;

/**
 * A helper class to connect and interact with a database.
 */
public class DBUtils {

    /**
     * Represents a connection to a database.
     */
    private Connection connection;

    /**
     * These are used to establish a connection to a database.
     */
    private String url, user, password;

    /**
     * Constructs a new `DBHelper` object with the specified database connection parameters.
     *
     * @param url      The URL of the database.
     * @param user     The username to connect to the database.
     * @param password The password to connect to the database.
     */
    public DBUtils(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    /**
     * Opens a connection to the database using the specified `url`, `user`, and `password`.
     *
     * @throws SQLException If a database access error occurs.
     */
    public void open() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    /**
     * Closes the current database connection.
     *
     * @return `true` if the connection was closed successfully, `false` otherwise.
     * @throws SQLException If a database access error occurs.
     */
    public boolean close() throws SQLException {
        if (connection == null) return false;

        connection.close();
        return true;
    }

    public boolean tableExists(String tableName) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[] {"TABLE"});

        return resultSet.next();
    }

    /**
     * Returns the current database connection.
     *
     * @return The current database connection.
     */
    public Connection getConnection() {
        return connection;
    }
}
