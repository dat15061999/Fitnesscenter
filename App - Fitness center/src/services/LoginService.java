package services;

import utils.AppUtils;
import utils.Check;
import utils.GetValue;

import static page.AdminPage.adminPage;
import static page.ClientPage.clientPage;
import static page.TrainerPage.trainerPage;
import static services.AdminService.historyLoginAdmin;
import static view.ClientView.addClient;

public class LoginService implements Check {

    @Override
    public void createUser() {
        addClient();
    }

    @Override
    public void checkLogin(String userName, String passWord) {
        if (AdminService.getByUserName(userName) != null && AdminService.getByUserName(userName).
                getPassword().getPasscode().
                equals(AppUtils.hashPassword(passWord,
                        AdminService.getByUserName(userName).
                                getPassword().getKey()))) {
            System.out.println("Dang nhap Admin Page thanh cong");
            historyLoginAdmin(AdminService.getByUserName(userName));
            adminPage();
        } else if (TrainerService.getByUserName(userName) != null && TrainerService.getByUserName(userName).
                getPassword().getPasscode().
                equals(AppUtils.hashPassword(passWord,
                        TrainerService.getByUserName(userName).getPassword().getKey()))) {
            System.out.println("Dang nhap Trainer Page thanh cong");
            trainerPage(userName);
        } else if (ClientService.getByUserNameCLient(userName) != null && ClientService.getByUserNameCLient(userName).
                getPassword().getPasscode().
                equals(AppUtils.hashPassword(passWord,
                        ClientService.getByUserNameCLient(userName).getPassword().getKey()))) {
            System.out.println("Dang nhap Client Page thanh cong");
            clientPage(userName);
        } else {
            System.out.println("Sai ten dang nhap hoac mat khau");
            checkLogin(GetValue.getString("Nhap lai username"),GetValue.getString("Nhap lai password"));
        }
    }
}


