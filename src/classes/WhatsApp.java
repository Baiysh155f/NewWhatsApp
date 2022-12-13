package classes;

import enums.Status;

import java.util.ArrayList;
import java.util.List;

public class WhatsApp {
    private String phoneNumber;
    private String name;
    private String password;
    private Status status = Status.ПРИВЕТЬ_Я_ИСПОЛЬЗУЮ_WHATSAPP;
    private String images;
    private List<Contact> contacts = new ArrayList<>();

    private List<Group> groups;

    public void addGroup(Group group){
        if (groups == null){
            groups = new ArrayList<>();
        }
        groups.add(group);
    }


    public WhatsApp() {
    }

    public WhatsApp(String phoneNumber, String name, String password, Status status, String images) {

        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
        this.status = status;
        this.images = images;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Phone Number :" + phoneNumber +
                "\nName :" + name +
                "\nPassword :" + password +
                "\nStatus :" + status +
                "\nImages :" + images +
                "\nContacts :" + contacts+
                "\n>>>>>>>>>>><<<<<<<<<<<";
    }


}
