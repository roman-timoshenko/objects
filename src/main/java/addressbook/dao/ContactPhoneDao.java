package addressbook.dao;

import java.util.List;

public interface ContactPhoneDao {
    void add(int userId, String phone);
    String getOne (int userId);
    void delete (int userId);
    List<String> getAll (int userId);
}
