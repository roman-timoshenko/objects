package addressbook.dao.jdbc;

import addressbook.dao.ContactAddressDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class JdbcContactAddressDao implements ContactAddressDao {
    private final DataSource dataSource;

    public JdbcContactAddressDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public Integer get(int contactId) throws SQLException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT address_id FROM contact_address WHERE contact_id=?")) {
            statement.setInt(1, contactId);
            try  (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
                return null;
            }
        }
    }

    @Override
    public void add(int contactId, int addressId) throws SQLException {

    }

    @Override
    public void delete(int contactId) throws SQLException {

    }

    @Override
    public Map<Integer, Integer> getAll() throws SQLException {
        return null;
    }
}
