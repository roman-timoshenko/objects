package addressbook.dao;

import addressbook.model.Address;

public interface AddressDao {
    void add (String town, String street, int house, int flat);
    Address get (int id);
    void delete (int id);
}
