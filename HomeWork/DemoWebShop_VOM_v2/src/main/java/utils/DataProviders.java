package utils;

import data.Registration;
import data.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Registration> getRegistrations() {
        List<Registration> registrations = new ArrayList<>();
        registrations.add(new Registration("larysagmail.com", "qwerty"));
        registrations.add(new Registration("larysa@gmail.com", "qwerty#"));
        return registrations.iterator();
    }

    @DataProvider
    public Iterator<Object[]> getUsers() {
        List<Object[]> objects = new ArrayList<>();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("createAccounts.csv");
            if (inputStream == null) {
                throw new FileNotFoundException("Файл createAccounts.csv не найден в папке ресурсов");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();

            while (line != null) {
                String[] splitLine = line.split(",");
                User user = new User(splitLine[0], splitLine[1]);
                objects.add(new Object[]{user, splitLine[2], splitLine[3], splitLine[4]});
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

