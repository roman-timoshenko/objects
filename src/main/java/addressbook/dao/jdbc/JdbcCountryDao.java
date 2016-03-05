package addressbook.dao.jdbc;

import addressbook.dao.CountryDao;
import addressbook.model.Country;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCountryDao implements CountryDao {
    private final DataSource dataSource;

    public JdbcCountryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(String name) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO country VALUES (?)");
        statement.setString(2, name);
        statement.executeUpdate();
    }

    public Country get(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM country WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            Country country = new Country(id, name);
            return country;
        }
        return null;
    }

    public void delete(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM country WHERE id = ?");
        statement.setInt(1,id);
        statement.executeUpdate();
    }
}
