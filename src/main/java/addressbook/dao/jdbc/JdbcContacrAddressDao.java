package addressbook.dao.jdbc;

import addressbook.dao.ContactAddressDao;

import java.sql.SQLException;
import java.util.Map;

public class JdbcContacrAddressDao implements ContactAddressDao {
    @Override
    public Integer getOne(int contactId) throws SQLException {
        return null;
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
