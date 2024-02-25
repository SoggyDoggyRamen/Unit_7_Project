import java.util.ArrayList;

public class Address {
    private String houseNumber;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String state;
    private String zipCode;

    public Address(String houseNumber, String streetName, String apartmentNumber, String city, String state, String zipCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(Address address){
        this.houseNumber = address.getHouseNumber();
        this.streetName = address.getStreetName();
        this.apartmentNumber = address.getApartmentNumber();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipCode = address.getZipCode();
    }

    public Address(String address) {
        this.houseNumber = address.substring(0, address.indexOf(" "));
        if (address.contains("Apt")) {
            this.streetName = address.substring(address.indexOf(" ") + 1, address.indexOf("Apt") - 1);
            address = address.substring(address.indexOf("Apt"));
            this.apartmentNumber = address.substring(address.indexOf(" ") + 1, address.indexOf(","));
        }
        else {
            this.streetName = address.substring(address.indexOf(" ") + 1, address.indexOf(","));
        }
        address = address.substring(address.indexOf(",") + 2);
        this.city = address.substring(0, address.indexOf(","));
        address = address.substring(address.indexOf(" ") + 1);
        this.state = address.substring(0, address.indexOf(" "));
        this.zipCode = address.substring(address.indexOf(" ") + 1);
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString() {
        return houseNumber + " " + streetName + " Apt " + apartmentNumber + ", " + city + ", " + state + " " + zipCode;
    }
}
