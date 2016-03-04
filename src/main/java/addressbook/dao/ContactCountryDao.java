package addressbook.dao;

import java.sql.SQLException;

public interface ContactCountryDao {
    int get (int userId) throws SQLException;
    void add (int userId,int countryId) throws SQLException;
    void delete (int userId) throws SQLException;

}
