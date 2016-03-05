package addressbook.dao;

import addressbook.model.Contact;

import java.sql.SQLException;

public interface ContactDao {
    void add (String fisrtName, String lastName) throws SQLException;
    Contact get (int id) throws SQLException;
    void delete(int id) throws SQLException;
}
