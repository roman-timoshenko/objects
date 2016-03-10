package addressbook.dao.jdbc;

import addressbook.dao.ContactDao;
import addressbook.model.Contact;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcContactDao implements ContactDao {
    private final DataSource dataSource;

    public JdbcContactDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Contact add(String firstName, String lastName) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO contact (first_name, last_name) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return new Contact(id, firstName, lastName);
                }

            }
        }
        return null;
    }


    public Contact getById(int id) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT (first_name, last_name) FROM contact WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String firstName = resultSet.getString(1);
                    String lastName = resultSet.getString(2);
                    return new Contact(id, firstName, lastName);
                }
                return null;
            }
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM contact WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    @Override
    public Contact getByName(String firstName, String lastName) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id FROM contact WHERE (first_name=? AND last_name = ?)")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Contact (resultSet.getInt(1), firstName, lastName);
                }
                return null;
            }
        }
    }
}
