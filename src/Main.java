import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean using = true;
        printOptionScreen();

        while(using) {
            System.out.print("Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    findContact();
                    break;
                case 5:
                    mobilePhone.printContacts();
                    break;
                case 6:
                    printOptionScreen();
                    break;
                case 7:
                    using = false;
                    System.out.println("Program ended");
                    break;
                default:
                    System.out.println("Please select a valid option");
            }
        }
    }

    public static void printOptionScreen() {
        System.out.println("---- WELCOME TO YOUR MOBILE PHONE ----");
        System.out.println("1. Add Contact");
        System.out.println("2. Remove Contact");
        System.out.println("3. Modify Contact Information");
        System.out.println("4. Find Contact");
        System.out.println("5. Print Contact List");
        System.out.println("6. Print Option Menu");
        System.out.println("7. Exit Program");
    }

    public static void addContact() {
        System.out.print("Enter contact first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter contact last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();

        mobilePhone.addContact(firstName, lastName, phoneNumber);
    }

    public static void removeContact() {
        System.out.print("Enter contact name to remove: ");
        mobilePhone.removeContact(scanner.nextLine());
    }

    public static void findContact() {
        System.out.println("Enter contact name or number to search: ");
        String contact = scanner.nextLine();
        if(mobilePhone.findContact(contact) >= 0) {
            System.out.println("Found contact: " + mobilePhone.getContactInfo(contact));
        } else {
            System.out.println("Contact not found");
        }
    }

    public static void modifyContact() {
        System.out.print("Enter contact to modify: ");
        String currentInfo = scanner.nextLine();

        while (true) {
            System.out.println("1. Edit first name");
            System.out.println("2. Edit last name");
            System.out.println("3. Edit phone number");
            int choice = scanner.nextInt();

            if(choice > 3 || choice < 1) {
                System.out.println("Please enter a valid option");
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Enter new info: ");
                String newInfo = scanner.nextLine();
                mobilePhone.modifyContact(choice, currentInfo, newInfo);
                break;
            }
        }

    }
}
