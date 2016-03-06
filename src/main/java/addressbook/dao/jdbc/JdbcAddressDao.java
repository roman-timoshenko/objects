package addressbook.dao.jdbc;

import addressbook.dao.AddressDao;
import addressbook.model.Address;

import javax.sql.DataSource;
import java.sql.*;


public class JdbcAddressDao implements AddressDao{
    private final DataSource dataSource;


    public JdbcAddressDao(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public void add(String town, String street, int house, int flat) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO address (town, street, house, flat) VALUES (?,?,?,?)");
        statement.setString(1,town);
        statement.setString(2,street);
        statement.setInt(3,house);
        statement.setInt(4,flat);
        statement.executeUpdate();
    }

    public Address get(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT town, street, house, flat FROM address WHERE id = ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
        String town = resultSet.getString(1);
        String street = resultSet.getString(2);
        int house = resultSet.getInt(3);
        int flat = resultSet.getInt(4);
        Address address = new Address (id, town, street, house, flat) ;
            return address; }
        connection.close();
        statement.close();
        resultSet.close();
        return null;
    }

    public void delete(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM address WHERE id = ?");
        statement.setInt(1,id);
        statement.executeUpdate();
        connection.close();
        statement.close();
    }

}
