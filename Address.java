// Coded by Ethan Joerz
// Last modified 3/12/22
// Basic storage class for saving addresses

import java.io.Serializable;

public class Address implements Serializable {

    private String streetAddressLine1;
    private String streetAddressLine2;
    private String apptNumPOBox;
    private String zipcode;
    private String city;
    private String state;

    public Address(String newStreetAddressLine1, String newStreetAddressLine2, String newApptNumPOBox, String newZipcode, String newCity, String newState) {
        this.streetAddressLine1 = newStreetAddressLine1;
        this.streetAddressLine2 = newStreetAddressLine2;
        this.apptNumPOBox = newApptNumPOBox;
        this.zipcode = newZipcode;
        this.city = newCity;
        this.state = newState;
    }

    // boolean return setters below here with redundant checks on values, returns can be modified later if necessary, bools for sake of consistency

    public boolean setStreetAddressLine1(String newStreetAddressLine1) {
        this.streetAddressLine1 = newStreetAddressLine1;
        // This should be trivial, but to be extra double extremely sure
        if(this.streetAddressLine1.equals(newStreetAddressLine1)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean setStreetAddressLine2(String newStreetAddressLine2) {
        this.streetAddressLine2 = newStreetAddressLine2;
        // Should be trivial
        if(this.streetAddressLine2.equals(newStreetAddressLine2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean setApptNumPOBox(String newApptNumPOBox) {
        this.apptNumPOBox = newApptNumPOBox;
        // Should be trivial
        if (this.apptNumPOBox == newApptNumPOBox) {
            return true;
        }
        else{
            return false;
        }

    }

    public boolean setZipcode(String newZipcode) {
        this.zipcode = newZipcode;
        // Trivial
        if (this.zipcode == newZipcode) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean setCity(String newCity) {
        this.city = newCity;
        // Trivial
        if (this.city.equals(newCity)) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setState(String newState) {
        this.state = newState;
        // Trivial
        if(this.state.equals(newState)) {
            return true;
        }
        else {
            return false;
        }
    }

    // Simple Getters below here
    public String getStreetAddressLine1() {
        return this.streetAddressLine1;
    }

    public String getStreetAddressLine2() {
        return this.streetAddressLine2;
    }

    public String getApptNumPOBox() {
        return this.apptNumPOBox;
    }

    public String getZipcode() {
        return this.zipcode;
    }
    
    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }




}
