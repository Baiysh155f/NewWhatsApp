package interfacess;

import classes.Contact;
import classes.Group;
import classes.Person;
import classes.WhatsApp;

import java.util.List;

public interface WhatsapServices {
    void createPerson(List<Person> personList);

    void createWhatsapp(List<Person> personList, List<WhatsApp> whatsAppList);

    void addContact(List<WhatsApp> whatsAppList, WhatsApp whatsApp);

    void messenger(List<WhatsApp> whatsAppList, WhatsApp whatsApps, Contact contact);

    void getGroupMessage(List<WhatsApp> whatsAppList, WhatsApp whatsApp, Group group);
    void createGroup(List<WhatsApp> whatsAppList, WhatsApp whatsApp);
     void inGroup(List<WhatsApp> whatsApps , WhatsApp whatsApp , Group group);

}