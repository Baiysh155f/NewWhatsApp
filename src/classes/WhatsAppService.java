package classes;

import enums.Country;
import enums.Gender;
import enums.Status;
import interfacess.WhatsapServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class WhatsAppService implements WhatsapServices {

    @Override
    public void createPerson(List<Person> personList) {
        System.out.println("write ID");
        String id = new Scanner(System.in).nextLine();
        System.out.println("write phone number");
        String phoneNumber = new Scanner(System.in).nextLine();
        System.out.println("write name ");
        String nmae = new Scanner(System.in).nextLine();
        System.out.println("write country");
        String country = new Scanner(System.in).nextLine();
        System.out.println("write password");
        String password = new Scanner(System.in).nextLine();
        System.out.println("write gen");
        String gender = new Scanner(System.in).nextLine();
        personList.add(new Person(id, phoneNumber, nmae, Country.valueOf(country), password, Gender.valueOf(gender)));
        System.out.println(personList);
        System.out.println("create person successfully");

    }

    @Override
    public void createWhatsapp(List<Person> personList, List<WhatsApp> whatsAppList) {
        System.out.println("write phone number");
        String strPhoneNumber = new Scanner(System.in).nextLine();
        System.out.println("write name");
        String strName = new Scanner(System.in).nextLine();
        for (Person person : personList) {
            if (person.getPhoneNumber().equals(strPhoneNumber)) {
                System.out.println("write password");
                String strPassword = new Scanner(System.in).nextLine();
                if (person.getPassword().equals(strPassword)) {
                    whatsAppList.add(new WhatsApp(strPhoneNumber, strName, strPassword, Status.ПРИВЕТЬ_Я_ИСПОЛЬЗУЮ_WHATSAPP, "DEFOULT IMAGES"));
                }
            }
        }

    }

    @Override
    public void addContact(List<WhatsApp> whatsAppList, WhatsApp whatsApp) {
        while (true) {
            System.out.println("write phone number");
            String phoneNumber = new Scanner(System.in).nextLine();
            for (WhatsApp app : whatsAppList) {
                if (app.getPhoneNumber().equals(phoneNumber)) {
                    System.out.println("contact found :" + app.getName() + " " + app.getPhoneNumber());
                    System.out.println(" Save ? YEAS/NO");
                    String save = new Scanner(System.in).nextLine();
                    if (save.contains("yeas")) {
                        System.out.println("contact added");
                        whatsApp.getContacts().add(new Contact(app.getPhoneNumber(), app.getName()));
                    }
                }
            }
            break;
        }
    }

    @Override
    public void messenger(List<WhatsApp> whatsAppList, WhatsApp whatsApps, Contact contact) {

        String messenger = "";
        System.out.println("you wont to send sms YEAS/NO ?");

        String sms = new Scanner(System.in).nextLine();
        if (sms.contains("yeas")) {
            System.out.println("write sms");
            String word = new Scanner(System.in).nextLine();
            messenger = whatsApps.getName() + "->" + word;
            contact.getMessenger().add(messenger);
            for (WhatsApp whatsApp : whatsAppList) {
                if (whatsApp.getContacts() != null) {
                    for (Contact contacts : whatsApp.getContacts()) {
                        if (contacts.getPhoneNumber().contains(whatsApps.getPhoneNumber())) {
                            for (Contact contact1 : whatsApps.getContacts()) {
                                if (whatsApp.getPhoneNumber().contains(contact1.getPhoneNumber()) && whatsApp.getPhoneNumber().contains(contact.getPhoneNumber())) {
                                    contacts.getMessenger().add(messenger);
                                    System.out.println("Sms send");
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    @Override
    public void getGroupMessage(List<WhatsApp> whatsAppList, WhatsApp whatsApp, Group group) {
        String message = "";
        while (true) {
            System.out.println("you want send SMS (yes/no)?");
            String noYes = new Scanner(System.in).nextLine();
            if (noYes.toLowerCase().contains("yes")) {
                System.out.println("SMS");
                message = whatsApp.getName() + ": " + new Scanner(System.in).nextLine();
                System.out.println("send (yes/no)?");
                String yesOrNo = new Scanner(System.in).nextLine();
                if (yesOrNo.toLowerCase().contains("yes")) {
                    group.getGroupMessage().add(message);
                    for (String groupUser : group.getGroupUsers()) {
                        for (WhatsApp whatsApp1 : whatsAppList) {
                            if (groupUser.equals(whatsApp1.getName()) && !groupUser.equals(whatsApp.getName())) {
                                for (Group group1 : whatsApp1.getGroups()) {
                                    if (group1.getGroupName().equals(group.getGroupName())) {
                                        group1.getGroupMessage().add(message);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                break;
            }
        }
    }

    public void whatsappMethod(WhatsApp whatsApp, List<WhatsApp> whatsApps, WhatsAppService whatsAppService) {
        while (true) {
            System.out.println("""
                    press 1 to wild messages
                    press 2 to enter the group
                    press 3 to add contact
                    press 4 to create group
                    press 5 to log in profile
                    press 6 to change status
                    press 7 to exit back""");
            int strCase = new Scanner(System.in).nextInt();
            switch (strCase) {
                case 1:
                    if (whatsApp.getContacts() != null) {
                        for (int i = 0; i < whatsApp.getContacts().size(); i++) {
                            System.out.println(whatsApp.getContacts().get(i));
                            whatsApp.getContacts().get(i).getMessenger().forEach(System.out::println);
                        }
                        System.out.println("write name contact");
                        for (Contact contact : whatsApp.getContacts()) {
                            String name = new Scanner(System.in).nextLine();
                            if (contact.getUserName().contains(name)) {
                                System.out.println("\t\t" + contact.getUserName());
                            }
                            while (true) {
                                System.out.println("""
                                        press 1 to send messenger
                                        press 2 to see profile contact
                                        press 3 to remove all messenger
                                        press 4 to exit back""");
                                int s = new Scanner(System.in).nextInt();
                                switch (s) {
                                    case 1:
                                        whatsAppService.messenger(whatsApps, whatsApp, contact);
                                        break;
                                    case 2:
                                        for (WhatsApp app : whatsApps) {
                                            if (app.getName().contains(contact.getUserName())) {
                                                System.out.println(app);
                                            }
                                        }
                                        break;
                                    case 3:
                                        contact.getMessenger().clear();
                                        break;

                                } if (s==4){
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("contacts not found !");
                    }
                case 2:
                    if (whatsApp.getGroups() != null) {
                        for (int i = 0; i < whatsApp.getGroups().size(); i++) {
                            System.out.println(whatsApp.getGroups().get(i));
                            whatsApp.getGroups().get(i).getGroupMessage().forEach(System.out::println);
                        }
                        System.out.println("write name group");
                        String nameGroup = new Scanner(System.in).nextLine();
                        for (Group group : whatsApp.getGroups()) {
                            if (group.getGroupName().contains(nameGroup)) {
                                System.out.println("       " + group.getGroupName());
                                inGroup(whatsApps, whatsApp, group);
                            } else {
                                System.out.println("group not found !");
                            }
                        }
                    }
                    break;
                case 3:
                    whatsAppService.addContact(whatsApps, whatsApp);
                    break;
                case 4:
                    createGroup(whatsApps, whatsApp);
                    break;
                case 5:
                    System.out.println(whatsApp);
                    break;
                case 6:
                    System.out.println("change status");
                    break;
            }
            if (strCase == 7) {
                break;
            }
        }
    }

    @Override
    public void createGroup(List<WhatsApp> whatsAppList, WhatsApp whatsApp) {
        List<String> userName = new ArrayList<>();
        System.out.println("name group :");
        String nameGroup = new Scanner(System.in).nextLine();
        System.out.println("sees group member");
        while (true) {
            System.out.println("you want add member (yes/no)?");
            String str = new Scanner(System.in).nextLine();
            if (str.toLowerCase().contains("yes")) {
                System.out.println("name a member: ");
                String groupUser = new Scanner(System.in).nextLine();
                for (WhatsApp whatsApp1 : whatsAppList) {
                    if (groupUser.contains(whatsApp1.getName())) {
                        System.out.println(whatsApp1.getName() + "found you want add (yes/no)?");
                        String yesNo = new Scanner(System.in).nextLine();
                        if (yesNo.toLowerCase().contains("yes")) {
                            userName.add(whatsApp.getName());
                        }
                    }
                }
            } else {
                break;
            }
        }

        for (String name : userName) {
            for (WhatsApp names : whatsAppList) {
                if (name.trim().equals(names.getName())) {
                    names.addGroup(new Group(nameGroup, userName));
                }
            }
        }
        userName.add(whatsApp.getName());
        whatsApp.addGroup(new Group(nameGroup, userName));

    }

    @Override
    public void inGroup(List<WhatsApp> whatsApps, WhatsApp whatsApp, Group group) {
        while (true) {
            System.out.println("""
                    press 1 to send SMS
                    press 2 to sees group member
                    press 3 to delete all SMS
                    press 4 to exit back""");
            int strInt = new Scanner(System.in).nextInt();
            switch (strInt) {
                case 1:
                    getGroupMessage(whatsApps, whatsApp, group);
                    break;
                case 2:
                    System.out.println("all members :[" + group.getGroupUsers().size());
                    group.getGroupUsers().forEach(System.out::println);
                    break;
                case 3:
                    group.getGroupMessage().clear();
                    break;
            }
            if (strInt == 4) {
                break;
            }
        }
    }

}
