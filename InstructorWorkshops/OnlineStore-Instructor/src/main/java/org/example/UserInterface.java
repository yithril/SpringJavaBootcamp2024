package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private ShoppingCart shoppingCart = new ShoppingCart();
    ProductManager productManager = new ProductManager();

    public void homeScreen() {
        boolean isShopping = true;
        while (isShopping) {
            displayHomeScreenOptions();
            try {
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        displayProductSelectScreen();
                        break;
                    case 2:
                        displayCartScreen();
                        break;
                    case 3:
                        System.out.println("See you next time!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("That's not an option, sorry.");
                }
            } catch (Exception ex) {
                System.out.println("That is not an option, sorry");
                scanner.nextLine();
            }
        }
    }

    private void displayCartScreen(){
        boolean isDisplayingCartScreen = true;

        while(isDisplayingCartScreen){
            displayCart(this.shoppingCart);
            System.out.println("Select from the following options:");
            System.out.println("1. Remove item from cart");
            System.out.println("2. Check Out");
            System.out.println("3. Go back");

            try{
                int userInput = scanner.nextInt();

                switch(userInput){
                    case 1:
                        System.out.println("Please type the SKU of the product you'd like to remove.");
                        scanner.nextLine();
                        removeFromCart(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Thank you for shopping at Hop Mart!");
                        this.shoppingCart.clearShoppingCart();
                        isDisplayingCartScreen = false;
                        break;
                    case 3:
                        isDisplayingCartScreen = false;
                        break;
                    default:
                        System.out.println("That's not an option try again please.");
                        break;
                }
            }
            catch(Exception ex){
                System.out.println("That's not an option!");
                scanner.nextLine();
            }
        }
    }

    private void displayProductSelectScreen() {
        boolean isOnProductScreen = true;

        while (isOnProductScreen) {
            displayProducts();
            System.out.println("Select from the following options:");
            System.out.println("1. Search for product by name");
            System.out.println("2. Add product to cart");
            System.out.println("3. Search by price range");
            System.out.println("4. Search by department");
            System.out.println("5. Go back");

            int userInput = getInput();
            switch (userInput) {
                case 1:
                    searchAndDisplayProductsByName();
                    break;
                case 2:
                    promptAndAddProductToCart();
                    break;
                case 3:
                    searchAndDisplayProductsByPriceRange();
                    break;
                case 4:
                    searchAndDisplayProductsByDepartment();
                    break;
                case 5:
                    isOnProductScreen = false;
                    break;
                default:
                    System.out.println("Sorry, that's not an option. Try again, please.");
                    break;
            }
        }
    }

    private void displayHomeScreenOptions(){
        System.out.println("Welcome to Hop Mart loyal and faithful customer!");
        System.out.println("Select from the following options:");
        System.out.println("1. View all products");
        System.out.println("2. View current shopping cart items");
        System.out.println("3. Exit program");
    }

    private void displayProducts(){
        System.out.println("*************Product List***************");

        List<Product> productsToDisplay = productManager.loadProductsFromFile();

        for(int i = 0; i < productsToDisplay.size(); i++){
            Product p = productsToDisplay.get(i);
            System.out.printf("%d. SKU: %s Product Name: %s Price: $%.2f Department: %s %n", i + 1, p.getSku(), p.getProductName(), p.getPrice(), p.getDepartment());
        }
    }

    private void searchAndDisplayProductsByName() {
        System.out.println("Type in the name of the product you are searching for:");
        scanner.nextLine();
        String productName = scanner.nextLine();
        List<Product> productSearch = productManager.searchForProductsByName(productName);
        if (productSearch.isEmpty()) {
            System.out.println("No products found matching your search term.");
        } else {
            productSearch.forEach(product -> System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s %n", product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment()));
        }
    }

    private void searchAndDisplayProductsByPriceRange() {
        System.out.println("Enter minimum price:");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter maximum price:");
        double maxPrice = scanner.nextDouble();
        List<Product> products = productManager.getProductsByPriceRange(minPrice, maxPrice);
        displayProductsList(products);
    }

    private void searchAndDisplayProductsByDepartment() {
        System.out.println("Enter the department name:");
        scanner.nextLine();  // Consume leftover newline
        String department = scanner.nextLine();
        List<Product> products = productManager.getProductsByDepartment(department);
        displayProductsList(products);
    }

    private void displayProductsList(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            products.forEach(product -> System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s %n",
                    product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment()));
        }
    }

    private void promptAndAddProductToCart() {
        List<Product> products = productManager.loadProductsFromFile();
        System.out.println("Input the number of the product that you want to add to your shopping cart:");
        int productToAddToCart = getInput();
        if (productToAddToCart < 1 || productToAddToCart > products.size()) {
            System.out.println("Sorry, that is not a product you can select.");
        } else {
            Product selectedProduct = products.get(productToAddToCart - 1);
            shoppingCart.addProductToCart(selectedProduct);
            System.out.printf("You have added %s to your cart! %n", selectedProduct.getProductName());
        }
    }

    private int getInput() {
        try {
            return scanner.nextInt();
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("Invalid input. Please try again with a number.");
            return -1;
        }
    }

    private void displayCart(ShoppingCart cart){
        if(cart.getProductsInCart().size() == 0){
            System.out.println("No products in cart!");
        }
        else{
            for(int i = 0; i < cart.getProductsInCart().size(); i++){
                Product p = cart.getProductsInCart().get(i);
                System.out.printf("%d. SKU: %s Product Name: %s Price: $%.2f Department: %s %n", i + 1, p.getSku(), p.getProductName(), p.getPrice(), p.getDepartment());
            }
        }
    }

    private void removeFromCart(String sku){
        Product productToRemove = null;

        for(Product p : this.shoppingCart.getProductsInCart()){
            if(p.getSku().equalsIgnoreCase(sku)){
                productToRemove = p;
                break;
            }
        }

        if(productToRemove == null){
            System.out.println("There is no product in your cart with that SKU");
        }
        else{
            this.shoppingCart.removeProductFromCart(productToRemove);
        }
    }
}
