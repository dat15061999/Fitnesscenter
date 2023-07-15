package view;

import models.Product;
import services.ProductService;
import utils.GetValue;

import static view.UserView.userView;

public class ProductView {
    private static int choose;
    private static ProductService productService = new ProductService();
    static {
        productService.readFile();
    }

    public static void main(String[] args) {
        productView();
    }
    public static void productView() {
        printMenu();
        choose = GetValue.getInt("Enter your choice:");
        switch (choose) {
            case 1:
                addProduct();
                break;
            case 2:
                deleteProduct();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                printProduct();
                break;
            case 5:
                System.exit(5);
                break;
            case 0:
                userView();
                break;
            default:
                productView();
                break;
        }
        productView();
    }
    private static void printMenu() {
        System.out.println("               ===================================");
        System.out.println("               |           Product List          |");
        System.out.println("               ===================================");
        System.out.println("               | Options:                        |");
        System.out.println("               |        1. Create product        |");
        System.out.println("               |        2. Delete product        |");
        System.out.println("               |        3. Update product        |");
        System.out.println("               |        4. Print all product     |");
        System.out.println("               |        5. Exit All              |");
        System.out.println("               |        0. Back to program       |");
        System.out.println("               ===================================");
    }
    private static void addProduct() {
        productService.create(new Product());
    }
    private static void deleteProduct() {
        productService.delete(GetValue.getInt("Nhap id san pham muon xoa"));
    }
    private static void updateProduct() {
        productService.update(GetValue.getInt("Nhap id san pham muon chinh sua"));
    }
    public static void printProduct() {
        productService.getAll();
    }
}
