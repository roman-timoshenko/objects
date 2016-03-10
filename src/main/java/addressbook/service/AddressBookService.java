package addressbook.service;

import addressbook.dao.*;
import addressbook.model.Address;
import addressbook.dto.AddressBook;
import addressbook.model.Contact;
import addressbook.model.Country;

import java.sql.SQLException;

public class AddressBookService {
    private final ContactDao contactDao;
    private final ContactAddressDao contactAddressDao;
    private final ContactCountryDao contactCountryDao;
    private final ContactPhoneDao contactPhoneDao;
    private final AddressDao addressDao;
    private final CountryDao countryDao;

    public AddressBookService(ContactDao contactDao, ContactAddressDao contactAddressDao, ContactCountryDao contactCountryDao, ContactPhoneDao contactPhoneDao, AddressDao addressDao, CountryDao countryDao) {
        this.contactDao = contactDao;
        this.contactAddressDao = contactAddressDao;
        this.contactCountryDao = contactCountryDao;
        this.contactPhoneDao = contactPhoneDao;
        this.addressDao = addressDao;
        this.countryDao = countryDao;
    }

    public AddressBook addContact(String firstName, String lastName, String countryName, String town, String street, int house, int flat, String phone) throws SQLException {
        Contact contact = contactDao.add(firstName, lastName);
        Address address = addressDao.add(town, street, house, flat);
        contactAddressDao.add(contact.getId(), address.getId());
        contactPhoneDao.add(contact.getId(), phone);
        contactCountryDao.add(contact.getId(), countryDao.getIdByName(countryName));
        Country country = countryDao.getNameByID(countryDao.getIdByName(countryName));
        return new AddressBook(contact, address,country , phone);
    }

    public AddressBook getContact(String firstName, String lastName) throws SQLException {
        Contact contact = contactDao.getByName(firstName, lastName);
        Address address = addressDao.get(contactAddressDao.get(contact.getId()));
        Country country = countryDao.getNameByID(contactCountryDao.getOne(contact.getId()));
        String phone = contactPhoneDao.getOne(contact.getId());
        return new AddressBook(contact, address,country , phone);
    }
}
