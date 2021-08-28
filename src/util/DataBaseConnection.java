package util;

import util.models.IdName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseConnection {

    public static void main(String[] args) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zeal?user=root&password=root");
            System.out.println(connection);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select id, name from contract");
            List<IdName> idNames = new ArrayList<>();
            while (resultSet.next()) {
                idNames.add(new IdName(resultSet.getLong(1), resultSet.getString(2)));
            }
            System.out.println(idNames);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignored) {
                }
                statement = null;
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignored) {
                }
                resultSet = null;
            }
        }
    }
}
