package addressbook.dao.jdbc;

import addressbook.dao.ContactCountryDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class jdbcContactCountryDao implements ContactCountryDao{

    private final DataSource dataSource;

    public jdbcContactCountryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getOne(int contactId) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM contact_country WHERE contact_id=?");
        statement.setInt(1, contactId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int countryId = resultSet.getInt(2);
            return countryId;
        }
        return 0;
    }

    public void add(int contactId, int countryId) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO contact_country VALUES (?,?)");
        statement.setInt(1, contactId);
        statement.setInt(2, countryId);
        statement.executeUpdate();
    }

    public void delete(int contactId) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM contact_country WHERE contact_id = ?");
        statement.setInt(1, contactId);
        statement.executeUpdate();

    }

    public Map<Integer, Integer> getAll() throws SQLException {
        Connection connection = dataSource.getConnection();
        Map<Integer, Integer> contactCountries = new HashMap();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM contact_contry");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int contactId = resultSet.getInt(1);
            int countryId = resultSet.getInt(2);
            contactCountries.put(contactId, countryId);
        }
        return contactCountries;
    }
}
