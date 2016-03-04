package addressbook.dao;

import addressbook.model.Country;

import java.sql.SQLException;

public interface CountryDao {
    void add (String name) throws SQLException;
    Country get (int id) throws SQLException;
    void delete (int id) throws SQLException;

}
