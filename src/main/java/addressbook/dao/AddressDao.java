package addressbook.dao;

import addressbook.model.Address;

import java.sql.SQLException;

public interface AddressDao {
    Address add(String town, String street, String postalCode, int house, int flat) throws SQLException;
    Address get (int id) throws SQLException;
    void delete (int id) throws SQLException;
}
