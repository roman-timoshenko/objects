package addressbook.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ContactPhoneDao {
    void add(int contactId, String phone) throws SQLException;
    String getOne (int contactId) throws SQLException;
    void delete (int contactId) throws SQLException;
    Map<Integer,String> getAll (int contactId) throws SQLException;
}
