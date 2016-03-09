package addressbook;

import addressbook.dao.AddressDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        final ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println(context.getBean(AddressDao.class).add("ggfsjgj","ghsdjgjs",5,5));
    }
}
