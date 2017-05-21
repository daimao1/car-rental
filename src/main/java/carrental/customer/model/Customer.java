package carrental.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 50)
    private String fullName;

    @NotNull
    @Size(min=7, max=10)
    private String drivingLicenceNum;

    @NotNull
    @Size(min=3, max=30)
    private String country;

    @NotNull
    @Size(min=3, max=30)
    private String city;

    @NotNull
    @Size(min=5, max=40)
    private String address;

    @NotNull
    @Size(min=3, max=30)
    private String state;

    @NotNull
    @Size(min=5,max=5)
    private String zipCode;

    @NotNull
    @Size(min=9,max=12)
    private String phoneNum;

    public Customer() {
    }

    public Customer(String fullName, String drivingLicenceNum, String country, String city, String address, String state, String zipCode, String phoneNum) {
        this.fullName = fullName;
        this.drivingLicenceNum = drivingLicenceNum;
        this.country = country;
        this.city = city;
        this.address = address;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNum = phoneNum;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDrivingLicenceNum() {
        return drivingLicenceNum;
    }

    public void setDrivingLicenceNum(String drivingLicenceNum) {
        this.drivingLicenceNum = drivingLicenceNum;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}