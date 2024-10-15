package Controller;

import java.util.List;

import Controller.Product;
import Exception.InvalidProducIdException;
import Service.ProductService;
import Exception.NotFoundProductIdException;
import Validator.ProductValidator;
import Exception.InvalidProductNameException;
public class ProductController {
    private List<Product> products;
    private ProductService ps;
    public ProductController(ProductService ps) {
        this.ps = ps;
        this.products = ps.getProducts();
    }
    public Product getProductById(String id) {
        if (!ProductValidator.validateProductId(id)) {
            System.out.println("Product ID invalid.");
            return null;
        }
        try {
            Product product = ps.getProductById(id);
            return product;
        } catch (NotFoundProductIdException | InvalidProducIdException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Product> getProductByName(String name) {
        if (!ProductValidator.validateProductName(name)) {
            System.out.println("Product name invalid");
            return null;
        }
        try{
            List<Product> foundPrds = ps.getProductsByName(name);
            return foundPrds;
        }catch (NotFoundProductIdException | InvalidProductNameException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}