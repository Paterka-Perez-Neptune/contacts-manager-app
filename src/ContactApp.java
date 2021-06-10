import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class ContactApp {


    public static void main(String[] args) {
        List<String> currentList = new ArrayList<>();


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What would you like to search for?");
//        String userSearch = scanner.next();
//        if (currentList.contains(userSearch)) {


//        System.out.println("here is the item you search for: " + userSearch);
//    } else {
//            System.out.println("Sorry, we do not have that item available");
//        }
//


        Path toOurDataPlace = Paths.get("src");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");

        ///////////////// this is code to rewrite the file

        List<String> newContacts = Arrays.asList("Livia", "Agrippina", "Massaline", "Julia Domna");

        try {
            Files.write(toOurDataFile, newContacts);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        /////////////////////

//        List<String> currentList = new ArrayList<>();
// adds a string to the text file
        try {

            Files.write(
                    Paths.get(String.valueOf(toOurDataPlace), "contacts.txt"),
                    Arrays.asList("eggs"), // list with one item
                    StandardOpenOption.APPEND
            );
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        try { // read the file
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        for (String line : currentList) { // outputting all the file items
            System.out.println(line);
        }

// search feature for items

        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to search for?");
        String userSearch = scanner.next();
        if (currentList.contains(userSearch)) {
            System.out.println("here is the item you search for: " + userSearch);
        } else {
            System.out.println("Sorry, we do not have that item available");
        }

//delete feature
        //      List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(toOurDataFile);

            Iterator<String> listIterator = currentList.iterator();
            while (listIterator.hasNext()) {
                //String item = listIterator.next();
                if (currentList.contains("eggs")) {
                    listIterator.remove();
                }
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }
}

//        List<String> Files.readAllLines( src/contacts.txt);

