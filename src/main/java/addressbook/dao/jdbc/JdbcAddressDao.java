package addressbook.dao.jdbc;

import addressbook.dao.AddressDao;
import addressbook.model.Address;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcAddressDao implements AddressDao{
    private final DataSource dataSource;


    public JdbcAddressDao(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public void add(String town, String street, int house, int flat) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("INSERT INTO address (id, town, street, house, flat) VALUES (idGenerator, town, street, house, flat)");
    }

    public Address get(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT town, street, house, flat FROM address WHERE id = id");
      //  while (resultSet.next()) {
       // String town = resultSet.getString(town);
        // String street = resultSet.getString(street);
        // int house = resultSet.getInt(house);
        //  int flat = resultSet.getInt(flat);
        // Address address = new Address (id, town, street, house, flat);
        //  }
        return null;


    }

    public void delete(int id) {

    }

}
