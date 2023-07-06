package utils;

import java.io.*;

public class SerializationUtil {

    public static Object deserialize(String fileName) {
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            var ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("Errors File: " + e.getMessage());
        }
        return obj;
    }

    // serialize the given object and save it to file
    public static void serialize(Object obj, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            fos.close();
        } catch (Exception e) {
            System.out.println("Errors File: " + e.getMessage());
        }
    }
}

