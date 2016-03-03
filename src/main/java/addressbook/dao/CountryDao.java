package addressbook.dao;

import addressbook.model.Country;

public interface CountryDao {
    Country addCountry (String name);
    Country getCountry (int id);
    void deleteCountry (int id);

}
