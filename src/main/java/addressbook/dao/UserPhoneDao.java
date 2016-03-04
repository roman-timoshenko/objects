package addressbook.dao;

public interface UserPhoneDao {
    void add(int userId, String phone);
    String get (int userId);
    void delete (int userId);
}
