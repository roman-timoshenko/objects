package addressbook.dao;

import addressbook.model.Contact;

public interface ContactDao {
    Contact add (String name);
    Contact get (int id);
    void delete(int id);
}
