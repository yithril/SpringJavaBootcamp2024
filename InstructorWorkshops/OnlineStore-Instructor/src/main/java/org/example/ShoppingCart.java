package org.example;
import java.util.ArrayList;
public class ShoppingCart {
    private ArrayList<Product> productsInCart;

    public ShoppingCart(){
        productsInCart = new ArrayList<>();
    }

    //add products to the cart
    public void addProductToCart(Product product){
        this.productsInCart.add(product);
    }

    //remove products from the cart
    public void removeProductFromCart(Product product){
        this.productsInCart.remove(product);
    }

    //get a total cost of products in the cart
    public double getTotalCost(){
        double totalSum = 0;

        for(Product product : this.productsInCart){
            totalSum += product.getPrice();
        }

        return totalSum;
    }

    public ArrayList<Product> getProductsInCart() {
        return productsInCart;
    }

    public void clearShoppingCart(){
        this.productsInCart.clear();
    }
}
