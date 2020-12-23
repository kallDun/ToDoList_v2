package com.example.todolist;

import java.sql.*;

public class DatabaseTasks {

    private final String password = "1234";
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String tableName = "task";

    public DatabaseTasks(){
        try {
            connect();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public void insertTask(Task task){
        String SQL = "INSERT INTO " + tableName + "(id, content, postdate, duedate) " + "VALUES(?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement database = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            database.setLong(0, task.getId());
            database.setString(1, task.getContent());
            database.setDate(2, java.sql.Date.valueOf(task.getPostDate()));
            database.setDate(3, java.sql.Date.valueOf(task.getDueDate()));

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
