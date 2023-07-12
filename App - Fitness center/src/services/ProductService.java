package services;
import models.Product;
import utils.AppUtils;
import utils.CRUD;
import utils.GetValue;
import utils.SerializationUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService implements CRUD<Product>, Serializable {
    private static final long serialVersionUID = 4L;
    public static List<Product> productList;
    private static int nextIdProduct;
    public static String addressProduct = "products.txt";
    static {
        productList = (List<Product>) SerializationUtil.deserialize(addressProduct);
        if (productList.isEmpty()) {
            productList = new ArrayList<>();
        }
        nextIdProduct = AppUtils.findNext(productList.stream().map(e->e.getId()).collect(Collectors.toList()));
    }
    @Override
    public void create(Product product) {
        product.setId(nextIdProduct);
        product.setNameCard(GetValue.getCardClass("Chon hang san pham"));
        product.setStatus(GetValue.getStatusProduct("Chon trang thai"));
        product.setPriceCardClass(GetValue.getDou("Nhap gia su dung"));
        product.setExpiryDate(GetValue.getInt("Nhap han dung the (Tinh theo thang)"));
        productList.add(product);
        SerializationUtil.serialize(productList,addressProduct);
    }

    @Override
    public void delete(int idProduct) {
        Product productDelete = null;
        for (Product product : productList) {
            if (product.getId() == idProduct){
                productDelete = product;
                System.out.println("Xoa product co id la " + idProduct + " thanh cong.");
            }
        }
        productList.remove(productDelete);
        SerializationUtil.serialize(productList,addressProduct);
    }

    @Override
    public void update(int idProduct) {
        for (Product product: productList) {
            if (product.getId() == idProduct){
                System.out.println("Sua thong tin san pham");
                product.setNameCard(GetValue.getCardClass("Chon hang san pham"));
                product.setStatus(GetValue.getStatusProduct("Chon trang thai"));
                product.setPriceCardClass(GetValue.getDou("Nhap gia su dung"));
                product.setExpiryDate(GetValue.getInt("Nhap han dung the"));
                break;
            }
        }
        SerializationUtil.serialize(productList,addressProduct);
    }

    @Override
    public List readFile() {
        return productList;
    }

    @Override
    public void getAll() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                              Product List                            |");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-10s | %-10s | %-12s | %-20s |\n",
                "ID", "Name Card", "Exp", "Status", "Price Product");
        System.out.println("------------------------------------------------------------------------");
        for (Product product : productList) {
            System.out.println(product);
        }
    }
    //public Product createProductofBill(Product product) {
//        product.setId(nextIdProduct);
//        product.setNameCard(GetValue.getCardClass("Chon hang san pham"));
//        product.setStatus(GetValue.getStatusProduct("Chon trang thai"));
//        product.setPriceCardClass(GetValue.getDou("Nhap gia su dung"));
//        product.setExpiryDate(GetValue.getInt("Nhap han dung the (Tinh theo thang)"));
//        productList.add(product);
//        SerializationUtil.serialize(productList,addressProduct);
//    }
//
}
