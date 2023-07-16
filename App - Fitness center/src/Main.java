
import static page.TrainerPage.trainerPage;
import static utils.InitData.*;
import static view.BillView.billView;

public class Main {

    public static void main(String[] args) {
        initAdmin();
        initClient();
        initTrainer();
        initProduct();
        initBill();
        billView();
        //trainerPage("thanhpt");


    }
}