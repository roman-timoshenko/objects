package addressbook.dao;

import java.sql.SQLException;
import java.util.Map;

public interface ContactCountryDao {
    int getOne (int contactId) throws SQLException;
    void add (int contactId,int countryId) throws SQLException;
    void delete (int contactId) throws SQLException;
    Map<Integer,Integer> getAll () throws SQLException;

}
