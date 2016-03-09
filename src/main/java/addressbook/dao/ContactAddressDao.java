package addressbook.dao;

import java.sql.SQLException;
import java.util.Map;

public interface ContactAddressDao {
    Integer get(int contactId) throws SQLException;
    void add (int contactId,int addressId) throws SQLException;
    void delete (int contactId) throws SQLException;
    Map<Integer,Integer> getAll () throws SQLException;
}
