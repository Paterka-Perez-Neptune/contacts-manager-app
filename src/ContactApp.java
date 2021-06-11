import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.List;
import java.io.LineNumberReader;

import static java.nio.file.Files.readAllLines;

public class ContactApp {

//    Scanner scanner = new Scanner(System.in);
//
//
////    public int getLineNumber() {
////        return 0;
////    }
//
//    public boolean yesNo() {
//        String response = scanner.nextLine();
//        if (response.trim().equalsIgnoreCase("y") || response.trim().equalsIgnoreCase("yes")) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public static void main(String[] args) {

// displays the line of text from the contacts page
//        int n = 2; // The line number
//        String line;
//        try (BufferedReader br = new BufferedReader(new FileReader("src/contacts.txt"))) {
//            for (int i = 0; i < n; i++)
//                br.readLine();
//            line = br.readLine();
//            System.out.println(line);
//        }
//        catch(IOException e){
//            System.out.println(e);
//        }
        boolean x = false;

        // Scanner int UserEntry = new scanner.nextInt();
        do {
            List<String> currentList = new ArrayList<>(); // creates our array list

    //       this is connecting to our contacts.txt file
            Path toOurDataPlace = Paths.get("src");
            Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");

    //         reads the file
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
                        try {
                            Files.write(toOurDataFile, currentList);

                        System.out.println("please type the name of the contact you would like to add to your list");
                        String userAddItem = scanner.next();

                            if (currentList.contains(userAddItem)) {
                                // get to delete/modify the identical one
                                System.err.println("There's already a contact named " + userAddItem + ". Do you want to overwrite it? (Yes/No)");
                                String userOverwrite = scanner.next();

                                if (userOverwrite.equalsIgnoreCase("yes")) {
                                    for (String line : currentList) {
                                        if (line.contains(userAddItem))
                                            //   System.out.println(line);
                                            currentList.remove(userAddItem);
//          this is code to rewrite the file

                                    }
                                }
                                if (userOverwrite.equalsIgnoreCase("yes")) {
//                                        currentList.remove(userAddItem);
//                            //          this is code to rewrite the file
//                                        try {
//                                            Files.write(toOurDataFile, currentList);
//                                        } catch (IOException ioe) {
//                                            ioe.printStackTrace();
//                                        }
                                    Files.write(
                                            Paths.get(String.valueOf(toOurDataPlace), "contacts.txt"),
                                            Arrays.asList(userAddItem), // list with one item
                                            StandardOpenOption.APPEND);
                                } else {
                                    System.out.println("please retype the name of the contact you would like to add to your list");
                                    userAddItem = scanner.next();
                                    Files.write(
                                            Paths.get(String.valueOf(toOurDataPlace), "contacts.txt"),
                                            Arrays.asList(userAddItem),
                                            StandardOpenOption.APPEND);
                                }
                            } else {
                                Files.write(
                                        Paths.get(String.valueOf(toOurDataPlace), "contacts.txt"),
                                        Arrays.asList(userAddItem),
                                        StandardOpenOption.APPEND);
                            }
                        }catch (IOException ioe) {
                                ioe.printStackTrace(); }
                    } catch (ConcurrentModificationException cme) {
                        cme.printStackTrace();
                    }

                    //         reads the file
                    try {
                        currentList = Files.readAllLines(toOurDataFile);
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }

                    for (String line : currentList) {
                        System.out.println(line);
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
                        currentList.remove(userSearch2);
//          this is code to rewrite the file
                        try {
                            Files.write(toOurDataFile, currentList);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    } else {
                        System.out.println("Sorry, we do not have that contact");
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