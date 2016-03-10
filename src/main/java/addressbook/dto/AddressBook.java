package addressbook.dto;

import addressbook.model.Address;
import addressbook.model.Contact;
import addressbook.model.Country;

public class AddressBook {
    private Contact contact;
    private Address address;
    private Country country;
    private String phone;

    public AddressBook(Contact contact, Address address, Country country, String phone) {
        this.contact = contact;
        this.address = address;
        this.country = country;
        this.phone = phone;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public Country getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "contact=" + contact +
                ", address=" + address +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
