package Service;

import Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import Exception.NotFoundProductIdException;
import Global.Global;

public class ProductService {
    private List<Product> products;
    public ProductService(List<Product> products) {
        this.products = products;
    }
    public List<Product> getProducts() {
        return products;
    }
    public Product getProductById(String id) {
        Optional<Product> foundProduct = products.stream()
                .filter(product -> Global.ignoreCase(product.getId(), id))
                .findFirst();
        return foundProduct.orElse(null);
    }
    public List<Product> getProductsByName(String name) {
        List<Product> foundProducts = products.stream()
                .filter(product -> Global.ignoreCase(product.getName(),name))
                .toList();
        return foundProducts;
    }
}