import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class ContactApp {



    public static void main(String[] args) {

        Path toOurDataPlace = Paths.get("src");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");

        ///////////////// this is code to rewrite the file

        List<String> newContacts = Arrays.asList("Livia", "Agrippina", "Massaline", "Julia Domna");

        try {
            Files.write(toOurDataFile, newContacts);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        List<String> currentList = new ArrayList<>();

        /////////////////////

//        List<String> currentList = new ArrayList<>();

        try { // read the file
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        for (String line : currentList) { // outputting all the file items
            System.out.println(line);
        }





    }
}

//        List<String> Files.readAllLines( src/contacts.txt);

