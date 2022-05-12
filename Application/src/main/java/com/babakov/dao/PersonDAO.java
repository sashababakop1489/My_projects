package com.babakov.dao;

import com.babakov.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:mysql://localhost:3306/testDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
    public List<Person> index(){

        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL ="SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
                System.out.println(person.toString());
            }
            System.out.println(people);

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return people;
    }
    public Person show(int id){

        Person person = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Person WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

   public void save(Person person) {

       try {
           PreparedStatement preparedStatement = connection.prepareStatement(
                   "INSERT INTO Person VALUES(1, ?, ?, ?)");

           preparedStatement.setString(1, person.getName());
           preparedStatement.setInt(2, person.getAge());
           preparedStatement.setString(3, person.getEmail());

           preparedStatement.executeUpdate();

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

    public void update(int id, Person updatePerson) {

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?" );

            preparedStatement.setString(1, updatePerson.getName());
            preparedStatement.setInt(2, updatePerson.getAge());
            preparedStatement.setString(3, updatePerson.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(int id){

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM Person WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
