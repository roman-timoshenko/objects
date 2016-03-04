package addressbook.dao;

import addressbook.model.Contact;

import java.sql.SQLException;

public interface ContactDao {
    Contact add (String name) throws SQLException;
    Contact get (int id) throws SQLException;
    void delete(int id) throws SQLException;
}
