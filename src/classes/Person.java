package classes;

import enums.Country;
import enums.Gender;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Person {
    private String id;
    private String phoneNumber;
    private String name;
    private Country country;

    private String password;
    private Gender gender;

    private List<WhatsApp> whatsApps;

    public Person() {
    }

    public Person(String id, String phoneNumber, String name, Country country, String password, Gender gender) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.country = country;
        this.password = password;
        this.gender = gender;
    }

    public List<WhatsApp> getWhatsApps() {
        return whatsApps;
    }

    public void setWhatsApps(List<WhatsApp> whatsApps) {
        this.whatsApps = whatsApps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "ID :" + id +
                "\nPhone Number :" + phoneNumber +
                "\nName :" + name +
                "\nCountry :" + country +
                "\nPassword :" + password +
                "\nGender :" + gender +
                "\n>>>>>>>>>>><<<<<<<<<<<";
    }
}
