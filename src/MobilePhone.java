import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contactList = new ArrayList<>();

    public void printContacts() {
        System.out.println("\n---- CONTACT LIST ----");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println((i + 1) + "." + " Name: " + contactList.get(i).getFullName()
                    + ", Number: " + contactList.get(i).getPhoneNumber());
        }
    }

    public void addContact(String firstName, String lastName, String phoneNumber) {
        contactList.add(new Contact(firstName, lastName, phoneNumber));
        System.out.println(firstName + " " + lastName + " has been added as a contact");
    }

    public void removeContact(String nameOrNumber) {
        if (findContact(nameOrNumber) >= 0) {
            System.out.println("Name: " + getContactInfo(nameOrNumber) + " removed from contact list");
            contactList.remove(findContact(nameOrNumber));
        } else {
            System.out.println("Contact doesn't exist");
        }
    }

    public void modifyContact(int choice, String currentInfo, String newInfo) {
        if (findContact(currentInfo) >= 0) {
            switch (choice) {
                case 1:
                    contactList.get(findContact(currentInfo)).setFirstName(newInfo);
                    break;
                case 2:
                    contactList.get(findContact(currentInfo)).setLastName(newInfo);
                    break;
                case 3:
                    contactList.get(findContact(currentInfo)).setPhoneNumber(newInfo);
                    break;
            }
            System.out.println("Contact info changed");
        } else {
            System.out.println("Contact not found");
        }
    }

    public String getContactInfo(String nameOrNumber) {
        return contactList.get(findContact(nameOrNumber)).getFullName() +
                ", " + "Number: " + contactList.get(findContact(nameOrNumber)).getPhoneNumber();
    }

    public int findContact(String nameOrNumber) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getFirstName().contains(nameOrNumber)
                    || contactList.get(i).getLastName().contains(nameOrNumber)
                    || contactList.get(i).getPhoneNumber().contains(nameOrNumber)) {
                return i;
            }
            ;

        }
        return -1;
    }


    //GETTERS

}
