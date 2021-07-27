import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductManager implements Serializable {
    List<Product> list = new ArrayList<>();

    public ProductManager() {
    }

    public ProductManager(List<Product> list) {
        this.list = list;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
    public void addSp(Product product){
        list.add(product);
    }
    public void showAll(){
        for (Product Product:
             list) {
            System.out.println(Product);
        }
    }
    public List<Product> delete(String name){
        for(int i =0; i<list.size();i++){
            if(list.get(i).getTenSp().equals(name)){
                list.remove(i);
            }
        }
        return  list;
    }
}
