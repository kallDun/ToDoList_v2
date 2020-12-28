package com.example.todolist.jdbc;

import com.example.todolist.models.Task;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;

public class DatabaseTasks {

    private static final String password = "1234";
    private static final String url = "jdbc:postgresql://localhost:5432/tasks";
    private static final String user = "postgres";

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

    public void insertTask(Task task) throws SQLException, ClassNotFoundException {
        String SQL;
        SQL = MessageFormat.format("INSERT INTO task (id, content, postdate, duedate) {0}", String.format("VALUES('%s','%s','%s','%s')",
                task.getId(),
                task.getContent(),
                Date.valueOf(task.getPostDate()),
                Date.valueOf(task.getDueDate())));


        Connection conn = connect();
        Statement database = conn.createStatement();
        database.executeUpdate(SQL);
    }

    public ArrayList<ArrayList<String[]>> getTableTasks() throws SQLException, ClassNotFoundException {

        Connection conn = connect();
        Statement database = conn.createStatement();

        ArrayList<ArrayList<String[]>> result = new ArrayList<>();
        ResultSet rs = database.executeQuery("SELECT * FROM task");

        String[] rowNames = {"Id :", "Content :", "Postdate :", "DueDate :"};

        int columnCount = rs.getMetaData().getColumnCount();
        while(rs.next())
        {
            ArrayList<String[]> row = new ArrayList<>();

            for (int i = 0; i < 4; i++) {

                String[] paramet = new String[2];
                paramet[0] = rowNames[i];
                paramet[1] = (rs.getString(i + 1));
                row.add(paramet);
            }
            result.add(row);
        }

        return result;
    }

    /*private getTableTasksInArray() throws SQLException, ClassNotFoundException{


    }*/

}
