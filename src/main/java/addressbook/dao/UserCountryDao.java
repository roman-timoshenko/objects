package addressbook.dao;

public interface UserCountryDao {
    int getUserCountry (int userId);
    void addUserCountry (int userId,int countryId);
    void deleteUserCountry (int userId);

}
