import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        List<Product> list = manager.getList();
        Product product1 = new Product("c02", "Xe máy", "Honda", 50000000);Product product2 = new Product("c06", "ô tô", "Meserdest", 250000000);
        list.add(product1);
        list.add(product2);
        addAndWritetoSP("Product.txt",list );
        List<Product> List = ReadProduct("Product.txt");
        for (Product product :
                List) {
            System.out.println(product);

      }
        System.out.println("Nhập tên sản phẩm bạn muốn xoá");
        String name = scanner.nextLine();
          List<Product> List1 = manager.delete(name);
        addAndWritetoSP("Product.txt", List1);
        List<Product> list1 = ReadProduct("Product.txt");
        for (Product procduct:
             list1) {
            System.out.println(procduct);

        }



    }

    public static void addAndWritetoSP(String path, List<Product> list) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(list);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> ReadProduct(String path) {
        List<Product> list = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            list = (List<Product>) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return list;
    }

}
