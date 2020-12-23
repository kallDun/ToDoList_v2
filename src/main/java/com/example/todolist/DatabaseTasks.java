package com.example.todolist;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseTasks {

    private final String password = "1234";
    private final String url = "jdbc:postgresql://localhost:5432/tasks";
    private final String user = "postgres";

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
        String SQL =
                "INSERT INTO task (id, content, postdate, duedate) " +
                String.format("VALUES('%s','%s','%s','%s')",
                        task.getId(),
                        task.getContent(),
                        java.sql.Date.valueOf(task.getPostDate()),
                        java.sql.Date.valueOf(task.getDueDate()));

        try (Connection conn = connect();
             Statement database = conn.createStatement())
        {
            database.executeUpdate(SQL);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String[]> getTableTasks(){
        try (Connection conn = connect();
             Statement database = conn.createStatement())
        {
            ArrayList <String[]> result = new ArrayList<String[]>();

            ResultSet rs = database.executeQuery("SELECT * FROM task");
            int columnCount = rs.getMetaData().getColumnCount();

            while(rs.next())
            {
                String[] row = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = (rs.getString(i + 1));
                }
                result.add(row);
            }

            return result;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
