package addressbook.dao;

public interface UserPhoneDao {
    void addUserPhone (int userId, String phone);
    String getUserPhone (int userId);
    void deleteUserPhone (int userId);
}
