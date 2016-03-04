package addressbook.dao;

import java.sql.SQLException;
import java.util.List;

public interface ContactPhoneDao {
    void add(int userId, String phone) throws SQLException;
    String getOne (int userId) throws SQLException;
    void delete (int userId) throws SQLException;
    List<String> getAll (int userId) throws SQLException;
}
