package addressbook.dao;

public interface ContactCountryDao {
    int get (int userId);
    void add (int userId,int countryId);
    void delete (int userId);

}
