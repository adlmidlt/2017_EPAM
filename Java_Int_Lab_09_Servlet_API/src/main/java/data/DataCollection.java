package data;

import dto.Product;

import java.util.ArrayList;
import java.util.List;

public class DataCollection {

    private List<Product> productList = new ArrayList<>();

    public List<Product> dataCollection() {
        productList.add(new Product("Dark", "1350", "KalyanDark"));
        productList.add(new Product("Angel", "4322", "KalyanDark"));
        productList.add(new Product("Dufft", "3421", "KalyanDark"));
        productList.add(new Product("Adalya", "3213", "KalyanDark"));
        productList.add(new Product("Green", "6546", "KalyanDark"));
        productList.add(new Product("Sherbetli", "8674", "KalyanDark"));
        productList.add(new Product("Blue", "9634", "KalyanDark"));
        productList.add(new Product("Red", "2344", "KalyanDark"));
        return productList;
    }
}
