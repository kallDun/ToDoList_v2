package com.example.todolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final String password = "1234";
    private final String url = "jdbc:postgresql://localhost/5432";
    private final String user = "postgres";
    private final String databaseName = "tasks";


    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public long insertTask(Task task){
        String SQL = "INSERT INTO " + databaseName + ""

    }

    


}
