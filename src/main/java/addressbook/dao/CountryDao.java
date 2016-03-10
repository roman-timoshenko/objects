package addressbook.dao;

import addressbook.model.Country;

import java.sql.SQLException;

public interface CountryDao {
    Country add(String name) throws SQLException;
    Country getNameByID (int id) throws SQLException;
    void delete (int id) throws SQLException;
    Integer getIdByName(String name) throws SQLException;

}
