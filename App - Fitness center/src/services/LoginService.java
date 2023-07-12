package services;
import models.Admin;
import models.Client;
import models.Trainer;
import utils.Check;
import utils.GetValue;
import static page.AdminPage.adminPage;
import static page.ClientPage.clientPage;
import static page.TrainerPage.trainerPage;
import static services.AdminService.adminList;
import static services.AdminService.historyLoginAdmin;
import static services.ClientService.clientList;
import static services.TrainerService.trainerList;
import static view.ClientView.addClient;

public class LoginService implements Check {

    @Override
    public void createUser() {
        addClient();
    }

    @Override
    public void checkLogin(String userName, String passWord) {
        for (Admin admin : adminList) {
            if (admin.getUserName().equals(userName) && admin.getPassWord().equals(passWord)) {
                System.out.println("Dang nhap Admin Page thanh cong");
                historyLoginAdmin(admin);
                adminPage();
                return;
            }
        }
        for (Trainer trainer : trainerList) {
            if (trainer.getUserName().equals(userName) && trainer.getPassWord().equals(passWord)) {
                System.out.println("Dang nhap Trainer Page thanh cong");
                trainerPage(userName);
                return;
            }
        }
        for (Client client : clientList) {
            if (client.getUserName().equals(userName) && client.getPassWord().equals(passWord)) {
                System.out.println("Dang nhap Client Page thanh cong");
                clientPage(userName);
                return;
            }
        }
        System.out.println("Sai ten dang nhap hoac mat khau");
    }
}


