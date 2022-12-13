package classes;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String phoneNumber;
    private String userName;
    private List<String> messenger = new ArrayList<>();

    public Contact(String phoneNumber, String userName) {
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getMessenger() {
        return messenger;
    }

    public void setMessenger(List<String> messenger) {
        this.messenger = messenger;
    }

    @Override
    public String toString() {
        return "Phone Number :" + phoneNumber +
                "\nName :" + userName;
    }
}
