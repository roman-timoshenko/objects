package addressbook.dao.jdbc;

import addressbook.dao.ContactDao;
import addressbook.model.Contact;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcContactDao implements ContactDao{
    private final DataSource dataSource;

    public JdbcContactDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(String firstName, String lastName) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO contact VALUES (?,?)");
        statement.setString(3,firstName);
        statement.setString(4,lastName);
        statement.executeUpdate();
    }

    public Contact get(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM contact WHERE id = ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int addressId = resultSet.getInt(2);
            String firstName = resultSet.getString(3);
            String lastName = resultSet.getString(4);
            Contact contact = new Contact(id, addressId, firstName, lastName) ;
        return contact;}
        return null;
    }

    public void delete(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM contact WHERE id = ?");
        statement.setInt(1,id);
        statement.executeUpdate();
    }
}
