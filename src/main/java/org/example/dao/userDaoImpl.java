package org.example.dao;

import org.example.config.DbConfig;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userDaoImpl extends DbConfig implements userDao{
    @Override
    public User saveUser(User user) {

        try(Connection connection = connect();
            PreparedStatement  statement = connection.prepareStatement("INSERT INTO users(user_name,password) VALUES(?,?);");
            ResultSet resultSet = statement.getGeneratedKeys()){
            statement.setString(1, user.getName());
            statement.setString(2,user.getPassword());
            statement.executeUpdate();
            if(resultSet.next()){
                user.setId(resultSet.getLong(1));
            }
            return user;

        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> allUsers;
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users;");
            ResultSet set = statement.executeQuery()){
            allUsers = new ArrayList<>();
            while (set.next()){
                User user = new User(set.getLong("id"),
                        set.getString("user_name"), set.getString("password"));
                allUsers.add(user);
            }

            return allUsers;

        }catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
}
