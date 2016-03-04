package addressbook.model;

public class Contact {
    private int id;
    private int address_id;
    private String firstName;
    private String lastName;

    public Contact(int id, int address_id, String firstName, String lastName) {
        this.id = id;
        this.address_id = address_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", address_id=" + address_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

