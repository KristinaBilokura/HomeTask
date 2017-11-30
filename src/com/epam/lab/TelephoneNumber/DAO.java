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
            System.out.println("Find people with ukrainian numbers");
            queryPerson(con , person);
            System.out.println("Foreigners");
            ifThereforeigners(con, person);
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static void queryPerson(Connection con , Person person) throws Exception {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name,number FROM git.people where number like '+380%'");
        while (resultSet.next()) {
            System.out.println("Name  : " + resultSet.getString(person.getName())+"Number :"+ resultSet.getString(person.getNumber())
            ) ;
        }
        System.out.println("Department table!");
    }
    public static void ifThereforeigners(Connection con , Person person) throws Exception {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name,surname FROM git.people where decimile not like 'UA'");
        while (resultSet.next()) {
            System.out.println("Name: " + resultSet.getString(person.getName())+"Surname :"+ resultSet.getString(person.getSurname())
            ) ;
        }
        System.out.println("Department table!");
    }
}
