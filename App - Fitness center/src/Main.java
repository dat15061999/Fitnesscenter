import services.AdminService;
import utils.GetValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static page.AdminPage.adminPage;
import static utils.InitData.*;
import static view.UserView.userView;

public class Main {
    static AdminService adminService = new AdminService();
    public static void main(String[] args) {
        initAdmin();
        initClient();
        initTrainer();
        initProduct();
        initBill();
        //adminPage();
//        String str = "Phung Anh       Tuan";
//
//        List<String> list = Arrays.asList(str.split("\\s+"));
//        System.out.println(list);
//        int l = 0;
//        int r = list.size()-1;
//        while (l < r) {
//            if (list.get(l).isEmpty()) {
//                l++;
//            } else if (list.get(r).isEmpty()) {
//                r--;
//            }
//            list2.add(list.get(r));
//        }
//        for (String str1: list2) {
//            System.out.println(str1);
//        }


    }
}