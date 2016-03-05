package addressbook.dao.jdbc;

import addressbook.dao.AddressDao;
import addressbook.model.Address;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;


public class JdbcAddressDao implements AddressDao{
    private final DataSource dataSource;


    public JdbcAddressDao(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public void add(String town, String street, int house, int flat) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO address VALUES (?,?,?,?)");
        statement.setString(2,town);
        statement.setString(3,street);
        statement.setInt(4,house);
        statement.setInt(5,flat);
        statement.executeUpdate();
    }

    public Address get(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM address WHERE id = ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery("SELECT town, street, house, flat FROM address WHERE id = ?");
        while (resultSet.next()) {
        String town = resultSet.getString(2);
        String street = resultSet.getString(3);
        int house = resultSet.getInt(4);
        int flat = resultSet.getInt(5);
        Address address = new Address (id, town, street, house, flat) ;
            return address; }
        return null;
    }

    public void delete(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM address WHERE id = ?");
        statement.setInt(1,id);
        statement.executeUpdate();
    }

}
