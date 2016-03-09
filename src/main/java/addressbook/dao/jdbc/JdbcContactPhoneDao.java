package addressbook.dao.jdbc;

import addressbook.dao.ContactPhoneDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JdbcContactPhoneDao implements ContactPhoneDao {
    private final javax.sql.DataSource dataSource;

    public JdbcContactPhoneDao(javax.sql.DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(int userId, String phone) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO phone (contact_id, phone) VALUES (?,?)")) {
            statement.setInt(1, userId);
            statement.setString(2, phone);
            statement.executeUpdate();
        }
    }

    public String getOne(int contactId) throws SQLException {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT phone FROM phone WHERE contact_id=?")) {
            statement.setInt(1, contactId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String phone = resultSet.getString(1);
                    resultSet.close();
                    return phone;
                }
            }
        }
        return null;
    }

    public void delete(int contactId) throws SQLException {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM phone WHERE contact_id = ?")) {
            statement.setInt(1, contactId);
            statement.executeUpdate();
        }
    }

    public Map<Integer, String> getAll(int userId) throws SQLException {
        Map<Integer, String> phones = new HashMap<>();
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM phone");
        ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int contactId = resultSet.getInt(1);
                String phone = resultSet.getString(2);
                phones.put(contactId, phone);
            }
            return phones;
        }
    }
}
