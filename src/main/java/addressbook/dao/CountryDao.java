package addressbook.dao;

import addressbook.model.Country;

public interface CountryDao {
    void add (String name);
    Country get (int id);
    void delete (int id);

}
