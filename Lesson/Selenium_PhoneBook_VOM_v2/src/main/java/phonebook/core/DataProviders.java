package phonebook.core;

import org.testng.annotations.DataProvider;
import phonebook.data.Contact;
import phonebook.data.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DataProviders {

    @DataProvider
    public Iterator<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("manuelgm.com", "Manuel1234$"));
        users.add(new User("manuel@g.com", "Manuel1234$"));
        users.add(new User("manuel@go.com", "masdfa1$"));
        users.add(new User("manuel@go.com", "MASdfa1"));
        users.add(new User("manuel@go.com", "MASdfa$"));
        return users.iterator();
    }

    @DataProvider
    public Iterator<Object[]> getContactsFromCsvFile() {
        List<Object[]> objects = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
            String line = reader.readLine();

            while (line != null) {
                String[] splitLine = line.split(",");
                Contact contact = new Contact(splitLine[0],splitLine[1],splitLine[2],splitLine[3],splitLine[4],splitLine[5]);
                objects.add(new Object[]{contact, splitLine[6]});
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return objects.iterator();
    }

}
