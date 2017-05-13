package pl.sda;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by RENT on 2017-05-13.
 */
public class MySQLService {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public MySQLService() {
        connect();
    }

    public String[][] getData(String query) {
        executeQuery(query);
        try {
            int columnCount = resultSet.getMetaData().getColumnCount();
            ArrayList<String[]> dataArr = new ArrayList<>();
            while (resultSet.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getString(i);

                }
                dataArr.add(rowData);
            }

          return  dataArr.toArray(new String[dataArr.size()][columnCount]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printData(String query) {
        executeQuery(query);
        try {
            int columnCount = resultSet.getMetaData().getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(resultSet.getMetaData().getColumnName(i) + '\t');

            }


            while (resultSet.next()) {
                System.out.println(

                );
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + '\t');

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void executeQuery(String quueryToExecute) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(quueryToExecute);
            System.out.println(resultSet.getMetaData().getColumnCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sakila?user=root");
        } catch (SQLException e) {
            connection = null;
            e.printStackTrace();

        }
    }


}
