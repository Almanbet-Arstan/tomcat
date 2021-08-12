package org.example.dao.daoImpl;

import org.example.dao.BaseDao;
import org.example.dao.UserDao;
import org.example.model.UserLogModel;
import org.example.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public UserModel createUser(UserModel userModel) {
        String sql = "INSERT INTO users(login, email, password, date_of_registration)" +
                "VALUES(?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Date date = new Date();
            userModel.setDateOfRegistration(new Timestamp(date.getTime()));
            connection = connect();
            statement = connection
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userModel.getLogin());
            statement.setString(2, userModel.getEmail());
            statement.setString(3, userModel.getPassword());
            statement.setTimestamp(4, userModel.getDateOfRegistration());

            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                userModel.setId(resultSet.getInt(1));
            }
            return userModel;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public UserLogModel createUserLog(UserLogModel userLogModel) {
        String sql = "INSERT INTO users_logs(is_success, user_id, time_log) " +
                "VALUES(?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Date date = new Date();
            userLogModel.setTimeLog(new Timestamp(date.getTime()));
            connection = connect();
            statement = connection
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setBoolean(1, userLogModel.getSuccess());
            statement.setInt(2, userLogModel.getUserId());
            statement.setTimestamp(3, userLogModel.getTimeLog());

            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                userLogModel.setId(resultSet.getInt(1));
            }
            return userLogModel;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public UserModel getByUsername(String username) {
        String sql = "SELECT id, login, email, password, date_of_registration " +
                "FROM users WHERE login = ?";

        ResultSet resultSet = null;
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setDateOfRegistration(resultSet.getTimestamp("date_of_registration"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public UserModel getByUserEmail(String userEmail) {
        String sql = "SELECT id, login, email, password, date_of_registration " +
                "FROM users WHERE email = ?";

        ResultSet resultSet = null;
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userEmail);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setDateOfRegistration(resultSet.getTimestamp("date_of_registration"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<UserLogModel> getAllUsersLogs() {
        String sql = "SELECT * FROM users_logs";
        List<UserLogModel> userLogModelList = null;

        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            userLogModelList = new ArrayList<>();

            while (resultSet.next()) {
                UserLogModel userLogModel = new UserLogModel();
                userLogModel.setId(resultSet.getInt("id"));
                userLogModel.setSuccess(resultSet.getBoolean("is_success"));
                userLogModel.setUserId(resultSet.getInt("user_id"));
                userLogModel.setTimeLog(resultSet.getTimestamp("time_log"));
                userLogModelList.add(userLogModel);
            }
            return userLogModelList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
