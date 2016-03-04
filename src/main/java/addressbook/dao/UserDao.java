package addressbook.dao;

import addressbook.model.User;

public interface UserDao {
    User addUser (String name);
    User getUser (int userId);
    void deleteUser(int userId);
    void addAddress (int userId, int addressId);
    int getAddressId (int userId);
    void deleteAddress (int userId);

}
