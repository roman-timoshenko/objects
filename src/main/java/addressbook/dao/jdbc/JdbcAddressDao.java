package addressbook.dao.jdbc;

import addressbook.dao.AddressDao;
import addressbook.model.Address;

import javax.sql.DataSource;
import java.sql.*;


public class JdbcAddressDao implements AddressDao {
    private final DataSource dataSource;


    public JdbcAddressDao(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public Address add(String town, String street, String postalCode, int house, int flat) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO address (town, street, postal_code, house, flat) VALUES (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, town);
            statement.setString(2, street);
            statement.setString(3, postalCode);
            statement.setInt(4, house);
            statement.setInt(5, flat);
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()){
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return new Address(id, town, street, postalCode, house, flat);
                }
            }
            return null;
        }
    }

    public Address get(int id) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT town, street, postal_code, house, flat FROM address WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String town = resultSet.getString(1);
                    String street = resultSet.getString(2);
                    String postalCode = resultSet.getString(3);
                    int house = resultSet.getInt(4);
                    int flat = resultSet.getInt(5);
                    return new Address(id, town, postalCode, street, house, flat);
                }
                return null;
            }
        }

    }

    public void delete(int id) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM address WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

}
