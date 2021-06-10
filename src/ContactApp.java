import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import static java.nio.file.Files.readAllLines;

public class ContactApp {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> currentList = new ArrayList<>(); // creates our array list

//       this is connecting to out contacts.txt file
        Path toOurDataPlace = Paths.get("src");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");

//         reads the file
        try {
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

//        USER MENU!
        System.out.println("1. View contacts.\n 2. Add a new contact\n 3. Search a contact by name.\n Delete an existing contact.\n 5 Exit\n Enter an option (1, 2, 3, 4 or 5):");
        if (scanner.nextInt() == 1) {
            //         outputting all the file items
            for (String line : currentList) {
                System.out.println(line);
            }
        }
        if (scanner.nextInt() == 2) {
            // this code to adds items to list
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
        }
        if (scanner.nextInt() == 3) {
            //        search for items
            System.out.println("What would you like to search for?");
            String userSearch = scanner.next();
            if (currentList.contains(userSearch)) {
                System.out.println("here is the item you search for: " + userSearch);
            } else {
                System.out.println("Sorry, we do not have that item available");
            }
        }
        if (scanner.nextInt() == 4) {
            //        delete feature
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
        }

        System.out.println(currentList); // checking list accuracy
    }
}