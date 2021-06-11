import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.List;

public class ContactApp {

    public static void main(String[] args) {

        boolean x = false;
        do {
            List<String> currentList = new ArrayList<>(); // creates array list
            //       connects to the contacts.txt file
            Path toOurDataPlace = Paths.get("src");
            Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");

            //         reads file
            try {
                currentList = Files.readAllLines(toOurDataFile);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

            //        USER MENU!
            System.out.println("\n1. View contacts.\n2. Add a new contact\n3. Search a contact by name.\n4. Delete an existing contact.\n5. Exit\n Enter an option (1, 2, 3, 4 or 5):");
            Scanner scanner = new Scanner(System.in);
            int userSelection = Integer.parseInt(scanner.nextLine().trim());
            switch (userSelection) {
                case 1:
                    //    View contacts
                    for (String line : currentList) {
                        System.out.println(line);
                    }
                    x = true;
                    break;
                case 2:
                    // Add a new contact
                    try {
                        System.out.println("Please type the name of the person you would like to add to your list");
                        String userAddName = scanner.nextLine();
                        System.out.println("Please type their phone number");
                        String userAddPhone = scanner.nextLine();
                        String newContact = userAddName + " | " + userAddPhone;
                        if (currentList.contains(userAddName)) {
                            System.err.println("There's already a contact named " + userAddName + ". Do you want to overwrite it? (Yes/No)");
                            if (scanner.next().equalsIgnoreCase("yes")) {
                                // need to remove item
                                Files.write(
                                        Paths.get(String.valueOf(toOurDataPlace), "contacts.txt"),
                                        Arrays.asList(newContact), // list with one item
                                        StandardOpenOption.APPEND);
                            } else {
                                do {
                                    System.out.println("please retype the name of the item you would like to add to your list");
                                    userAddName = scanner.next();
                                    if (currentList.contains(userAddName)) {
                                        System.err.println("There's already a contact with this name");
                                    } else {
                                        System.out.println("Success!!");
                                        // add remove stuff
                                        Files.write(
                                                Paths.get(String.valueOf(toOurDataPlace), "contacts.txt"),
                                                Arrays.asList(newContact),
                                                StandardOpenOption.APPEND);
                                    }
                                } while (currentList.contains(userAddName));
                            }
                        } else {
                            Files.write(
                                    Paths.get(String.valueOf(toOurDataPlace), "contacts.txt"),
                                    Arrays.asList(newContact), // list with one item
                                    StandardOpenOption.APPEND);
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    //    View contacts
                    x = true;
                    break;
                case 3:
                    // Search a contact by name
                    System.out.println("What would you like to search for?");
                    String userSearch = scanner.next();
                    for (String line : currentList) {
                        if (line.contains(userSearch))
                            System.out.println(line);
                    }
                    x = true;
                    break;
                case 4:



                    // Search a contact by number
                    System.out.println("What would you like to remove?");
                    String userSearch2 = scanner.next();
                    if (currentList.contains(userSearch2)) {

                        for (String line : currentList) {
                            if (line.contains(userSearch2));
                                currentList.remove(line);

                        }


//          this is code to rewrite the file
                        try {
                            Files.write(toOurDataFile, currentList);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    } else {
                        System.out.println("Sorry, we do not have that item");
                    }
                    x = true;
                    break;
                case 5:
                    // Exit
                    System.out.println("Thank you!!");
                    System.exit(0);
                default:
                    System.err.println("Please enter a number between 1 - 5!");
                    break;
            }
        } while (x = true);
    }
}
