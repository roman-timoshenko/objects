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

    public void add(String firstName, String lastName) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO contact (first_name, last_name) VALUES (?,?)");
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public Contact get(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT (address_id, first_name, last_name) FROM contact WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int addressId = resultSet.getInt(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            Contact contact = new Contact(id, addressId, firstName, lastName);
            return contact;
        }
        resultSet.close();
        statement.close();
        connection.close();
        return null;
    }

    public void delete(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM contact WHERE id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
