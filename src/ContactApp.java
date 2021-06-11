import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.List;
import java.io.LineNumberReader;

import static java.nio.file.Files.readAllLines;

public class ContactApp {

//    public int getLineNumber() {
//        return 0;
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

        // Scanner int UserEntry = new scanner.nextInt();
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


        boolean x = false;

        do {
            //        USER MENU!
            System.out.println("1. View contacts.\n2. Add a new contact\n3. Search a contact by name.\n4. Delete an existing contact.\n5. Exit\n Enter an option (1, 2, 3, 4 or 5):");
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
                        System.out.println("please type the name of the item you would like to add to your list");
                        String userAddItem = scanner.next();
                        Files.write(
                                Paths.get(String.valueOf(toOurDataPlace), "contacts.txt"),
                                Arrays.asList(userAddItem), // list with one item
                                StandardOpenOption.APPEND
                        );
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    x = true;
                    break;
                case 3:
                    // *** todo: Add the code from the hottodojava website so you can get the line number
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
                        System.out.println("Sorry, we do not have that item");
                    }
                    System.out.println(currentList);
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