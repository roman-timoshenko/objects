package addressbook.dao;

import addressbook.model.Contact;

import java.sql.SQLException;

public interface ContactDao {
    Contact add(String firstName, String lastName) throws SQLException;
    Contact getById (int id) throws SQLException;
    void delete(int id) throws SQLException;
    Contact getByName(String firstName, String lastName) throws SQLException;
}
