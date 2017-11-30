package com.epam.lab.TelephoneNumber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
    public static Connection getConnection() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/infostudent";
        String username ="root";
        String password ="1234";
        try(Connection con = DriverManager.getConnection(url, username, password)) {
            Class.forName(driver).newInstance();
            System.out.println("Connected successfully!");
            Person person = new Person();
            gueryDept(con , person);
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static void gueryDept(Connection con , Person person) throws Exception {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name,number FROM git.people where number like '+380%'");
        while (resultSet.next()) {
            System.out.println("Name  : " + resultSet.getString(person.getName())+"Number "+ resultSet.getString(person.getNumber())
            ) ;
        }
        System.out.println("Department table!");
    }
}
