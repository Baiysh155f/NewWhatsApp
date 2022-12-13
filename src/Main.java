import classes.Contact;
import classes.Person;
import classes.WhatsApp;
import classes.WhatsAppService;
import enums.Country;
import enums.Gender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<WhatsApp> whatsApps = new ArrayList<>();
        ArrayList<Contact> contacts = new ArrayList<>();
        ArrayList<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("1","1","b", Country.BISHKEK,"b", Gender.GENDER),
                new Person("2","2","v", Country.BISHKEK,"v", Gender.GENDER)));
        WhatsApp whatsApp = new WhatsApp();
        whatsApp.setContacts(contacts);
        WhatsAppService whatsAppService = new WhatsAppService();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("press 1 to create person");
            System.out.println("press 2 to create WhatsApp account");
            System.out.println("press 3 to enter Whatsapp");
            System.out.println("press 4 to exit back");
            int str = scanner.nextInt();
            switch (str){
                case 1:
                    whatsAppService.createPerson(persons);
                    break;
                case 2:
                    whatsAppService.createWhatsapp(persons,whatsApps);
                    System.out.println(whatsApps);
                    break;
                case 3:
                    System.out.println("write password");
                    String password = new Scanner(System.in).nextLine();
                    for (WhatsApp app : whatsApps) {
                        if (app.getPassword().contains(password)){
                            whatsAppService.whatsappMethod(app,whatsApps,whatsAppService);
                        }
                    }
                    break;

            }
            if (str == 4){
                break;
            }

        }
    }
}