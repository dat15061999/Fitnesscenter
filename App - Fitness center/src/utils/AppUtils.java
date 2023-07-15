package utils;
import models.Bill;
import models.Client;
import models.Password;
import models.Trainer;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import static view.BillView.billView;

public class AppUtils {
    private static int choose;
    public static int findNext(List<Integer> integers) {
        int max = 0;
        for (Integer integer : integers) {
            if (integer > max) {
                max = integer;
            }
        }
        return ++max;
    }

    public static String checkTrainer(String userName, List<Trainer> trainers) {
        boolean check = true;
        for (Trainer trainer : trainers) {
            if (trainer.getUsername().equals(userName)) {
                System.err.println("Tai khoan da ton tai!");
                check = false;
                break;
            }
        }
        if (check) {
            return userName;
        }
        return checkTrainer(GetValue.getString("Nhap userName"), trainers);
    }

    public static String checkClient(String userName, List<Client> clientList) {
        boolean check = true;
        for (Client client : clientList) {
            if (client.getUsername().equals(userName)) {
                System.err.println("Tai khoan da ton tai!");
                check = false;
                break;
            }
        }
        if (check) {
            return userName;
        }
        return checkClient(GetValue.getString("Nhap userName"), clientList);
    }

    public static Client checkBill(int idClient, List<Bill> billList, List<Client> clientList) {
        if (!billList.isEmpty() && !clientList.isEmpty()) {
            if ( billList.stream().anyMatch(bill -> bill.getId() == idClient)) {
                printMenu();
                choose = GetValue.getInt("Enter your choice ");
                switch (choose) {
                    case 1:
                        checkBill(GetValue.getInt("Nhap id khach hang"), billList, clientList);
                        break;
                    case 0:
                        billView();
                        break;
                }
                checkBill(GetValue.getInt("Nhap id khach hang"), billList, clientList);
            }
            return clientList.stream().filter(e -> e.getId() == idClient).findFirst().orElse(null);
        }
        return new Client();
    }
    public static  void printMenu() {
        System.err.println("Tai khoan da dang ky goi tap!");
        System.out.println("Moi chon: ");
        System.out.println("1. Tiep tuc chon khach hang");
        System.out.println("0. Back to program");
    }
    //Pass here:
    // 3 Constant: trong lop Constant
    // Tao lop Password để luu 2 giá trị passcode và key
    // Chinh sua 1 tý ở login service là xong!
    public static Password hashPassword(String password) {
        byte[] salt = generateSalt();
        byte[] hash = generateHash(password, salt);
        String encodedSaltAndHash = encodeSaltAndHash(salt, hash);
        return new Password(salt, encodedSaltAndHash);
    }

    public static String hashPassword(String password, byte[] salt) {
        byte[] hash = generateHash(password, salt);
        return encodeSaltAndHash(salt, hash);
    }

    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[Constant.SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    private static byte[] generateHash(String password, byte[] salt) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, Constant.ITERATIONS, Constant.KEY_LENGTH);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String encodeSaltAndHash(byte[] salt, byte[] hash) {
        byte[] saltAndHash = new byte[salt.length + hash.length];
        System.arraycopy(salt, 0, saltAndHash, 0, salt.length);
        System.arraycopy(hash, 0, saltAndHash, salt.length, hash.length);
        return Base64.getEncoder().encodeToString(saltAndHash);
    }
}
