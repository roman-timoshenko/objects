package addressbook.service;

import addressbook.dao.CountryDao;
import addressbook.model.Address;

import java.sql.SQLException;
import java.util.Arrays;

public class PhoneAddressService {
    private final CountryDao countryDao;

    public PhoneAddressService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public String convertInputPhone(String input, int countryId) {
        String phone = null;
        String[] temp = input.trim().split("-");
        for (String aTemp : temp) {
            phone = phone + Arrays.toString(temp);
        }
        return phone;
    }

    public String format(String phone, int countryId) {
        char[] temp = phone.toCharArray();
        if (countryId == 1 || countryId == 2 || countryId == 3) {
            String result = temp[0] + "-" + temp[1] + temp[2] + temp[3] + "-" + temp[4] + temp[5] + temp[6] + "-" + temp[7] + temp[8] + "-" + temp[9] + temp[10];
        }

        if (countryId == 4 || countryId == 5 || countryId == 6) {
            String result = temp[0] + temp[1] + temp[2] + temp[3] + "-" + temp[4] + temp[5] + temp[6] + temp[7] + "-" + temp[8] + temp[9] + temp[10];
        }
        return phone;

    }

    public String format(Address address, int countryId) throws SQLException {
        String rAddress = null;
        if (countryId == 1 || countryId == 2 || countryId == 3) {
            rAddress = address.getPostalCode() + " " + countryDao.getNameByID(countryId).getName() + " " + address.getTown() + " " + address.getStreet() + " " + address.getHouse() + " " + address.getFlat();
        }
        return rAddress;
    }
}
