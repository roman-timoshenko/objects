package addressbook.dao;

public interface UserCountryDao {
    int get (int userId);
    void add (int userId,int countryId);
    void delete (int userId);

}