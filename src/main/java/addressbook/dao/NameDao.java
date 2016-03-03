package addressbook.dao;

import addressbook.model.Name;

public interface NameDao {
    Name addName (String name);
    Name getName (int id);
    void deleteName (int id);
}
