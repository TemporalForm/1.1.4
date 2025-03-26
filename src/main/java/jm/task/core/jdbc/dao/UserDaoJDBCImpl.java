package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
/*import jm.task.core.jdbc.util.Util;*/

/*import java.sql.*;*/
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    /*private static final String insertUser = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)";*/

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        /*try (Connection conn = Util.getConnection(); Statement statement = conn.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(25) NOT NULL, " +
                    "lastname VARCHAR(50) NOT NULL, " +
                    "age INT(3) NOT NULL)");
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при создании таблицы", e);
        }*/
    }

    @Override
    public void dropUsersTable() {
        /*try (Connection conn = Util.getConnection(); Statement statement = conn.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS users");
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при удалении таблицы", e);
        }*/
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        /*try (Connection conn = Util.getConnection(); PreparedStatement statement = conn.prepareStatement(insertUser)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.execute();
            System.out.printf("User с именем — %s добавлен в базу данных\n", name);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при добавлении пользователя", e);
        }*/
    }

    @Override
    public void removeUserById(long id) {
        /*try (Connection conn = Util.getConnection(); Statement statement = conn.createStatement()) {
            statement.execute("DELETE FROM users WHERE id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при удалении пользователя", e);
        }*/
    }

    @Override
    public List<User> getAllUsers() {
        /*try (Connection conn = Util.getConnection(); Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastname"));
                user.setAge(rs.getByte("age"));
                users.add(user);
            }
            for (User user : users) {
                System.out.println(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при получении пользователей из таблицы", e);
        }*/
        return null;
    }

    @Override
    public void cleanUsersTable() {
        /*try (Connection conn = Util.getConnection(); Statement statement = conn.createStatement()) {
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при удалении всех пользователей из таблицы", e);
        }*/
    }
}
