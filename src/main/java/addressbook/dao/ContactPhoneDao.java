package addressbook.dao;

public interface ContactPhoneDao {
    void add(int userId, String phone);
    String get (int userId);
    void delete (int userId);
}
