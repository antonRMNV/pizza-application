package com.example.app.db;

import com.example.app.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBHandler extends Configuration {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionStr = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionStr, dbUser, dbPassword);
        return dbConnection;
    }

    public void signUpUser(User user) throws SQLException, ClassNotFoundException {
        String insertInformationAboutUser = "INSERT INTO " + FieldConstant.USER_TABLE +
                "(" + FieldConstant.USER_NAME + "," + FieldConstant.USER_SURNAME + "," +
                FieldConstant.USER_PHONENUMBER + "," + FieldConstant.USER_CITY +
                "," + FieldConstant.USER_LOGIN + "," + FieldConstant.USER_PASSWORD + ")" + " VALUES(?, ?, ?, ?, ?, MD5(?))";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insertInformationAboutUser);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getUserSurname());
        preparedStatement.setString(3, user.getUserPhonenumber());
        preparedStatement.setString(4, user.getUserCity());
        preparedStatement.setString(5, user.getUserLogin());
        preparedStatement.setString(6, user.getUserPassword());

        preparedStatement.executeUpdate();
    }

    public ResultSet getUser(User user) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        String userRequest = "SELECT * FROM " + FieldConstant.USER_TABLE + " WHERE " +
                FieldConstant.USER_LOGIN + "=? AND " + FieldConstant.USER_PASSWORD + "=MD5(?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(userRequest);
        preparedStatement.setString(1, user.getUserLogin());
        preparedStatement.setString(2, user.getUserPassword());

        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
}
