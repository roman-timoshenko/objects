package addressbook.model;

public class Address {
    int id;
    private String town;
    private String street;
    private String postalCode;
    private int house;
    private int flat;

    public Address(int id, String town, String street, String postalCode, int house, int flat) {
        this.id = id;
        this.town = town;
        this.street = street;
        this.postalCode = postalCode;
        this.house = house;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getHouse() {
        return house;
    }

    public int getFlat() {
        return flat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", house=" + house +
                ", flat=" + flat +
                '}';
    }
}