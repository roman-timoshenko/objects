package addressbook.dao;

import addressbook.model.Address;

import java.util.Map;

public interface UserAddressDao {
    void addUserAddress (int userId, String town, String street, int house, int flat);
    Map <Integer, Address> getAllUserAddress();
    void deleteUserAddress (int userId);
    Address getUserAddress (int userId);
}
