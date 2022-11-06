package ru.akirakozov.sd.refactoring.database;

import java.sql.*;


public class Database {

    private final String dbName;

    public Database(String s) {
        this.dbName = s;
    }

    public void execute(String request) throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbName)) {
            try (Statement statement = conn.createStatement()){
                statement.execute(request);
            }
        }
    }

    public ResultSet executeWithResult(String request) throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbName)) {
            try (Statement statement = conn.createStatement()){
                ResultSet rs = statement.executeQuery(request);
                statement.closeOnCompletion();
                return rs;
            }
        }
    }

}