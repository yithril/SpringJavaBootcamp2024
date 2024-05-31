package org.example;

import org.example.enums.IngredientType;
import org.example.enums.SandwichSize;

import java.math.BigDecimal;
import java.util.*;

public class UserInterface {
    private static Order order;
    private static final int screenSize;
    private UserInterface(){

    }

    static {
        order = new Order();
        screenSize = 70;
    }

    private static boolean areResourcesLoaded() {
        // Check if ingredients are loaded
        boolean ingredientsLoaded = !IngredientLoader.getIngredientByType(IngredientType.BREAD).isEmpty()
                && !IngredientLoader.getIngredientByType(IngredientType.MEAT).isEmpty()
                && !IngredientLoader.getIngredientByType(IngredientType.CHEESE).isEmpty()
                && !IngredientLoader.getIngredientByType(IngredientType.REGULAR_TOPPING).isEmpty()
                && !IngredientLoader.getIngredientByType(IngredientType.SAUCES).isEmpty()
                && !IngredientLoader.getIngredientByType(IngredientType.EXTRA_CHEESE).isEmpty()
                && !IngredientLoader.getIngredientByType(IngredientType.EXTRA_MEAT).isEmpty();

        // Check if side items are loaded
        boolean sideItemsLoaded = !SideItemLoader.getAllSideItems().isEmpty();

        return ingredientsLoaded && sideItemsLoaded;
    }

    public static void display(){
        if (!areResourcesLoaded()) {
            System.out.println("There was an error loading ingredients or side items. Please check the data files and restart the application.");
            System.exit(0);
        }

        System.out.println("Welcome to Jenky James! Our sandwiches are super mid!");

        boolean isInMenu = true;
        Scanner scanner = new Scanner(System.in);

        while(isInMenu){
            System.out.println("Select from the following options: ");
            System.out.println("1. View Order");
            System.out.println("2. Add Sandwich to Order");
            System.out.println("3. Add Side Items to Order");
            System.out.println("4. Restart Order");
            System.out.println("5. Check Out");
            System.out.println("6. Exit");

            try{
                int userInput = scanner.nextInt();

                switch(userInput){
                    case 1:
                        viewOrder();
                        break;
                    case 2:
                        buildSandwich();
                        break;
                    case 3:
                        addSideItemsToOrder();
                        break;
                    case 4:
                        clearOrder();
                        break;
                    case 5:
                        checkout();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Not a valid option please try again.");
                        break;
                }

            }
            catch (InputMismatchException ex){
                System.out.println("Please type a number.");
                scanner.nextLine();
            }
        }
    }

    private static void addSideItemsToOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean addingSideItems = true;

        while (addingSideItems) {
            System.out.println("Select a side item to add to your order, or type 'done' to finish:");

            displaySideItems();

            String input = scanner.nextLine();

            if ("done".equalsIgnoreCase(input)) {
                addingSideItems = false;
            } else {
                Optional<SideItem> selectedSideItem = getValidSideItem(input);
                selectedSideItem.ifPresentOrElse(
                         sideItem -> {
                             order.addSideItem(sideItem);
                             System.out.println("Adding '" + sideItem.getName());
                         },
                        () -> System.out.println("Not a valid side item, try again.")
                );
            }
        }
    }

    private static void displaySideItems() {
        List<SideItem> allSideItems = SideItemLoader.getAllSideItems();
        for (SideItem sideItem : allSideItems) {
            System.out.println(sideItem.getName() + " - $" + sideItem.getPrice());
        }
    }

    private static void buildSandwich(){
        Scanner scanner = new Scanner(System.in);
        Sandwich sandwich = null;

        while(true){
            Sandwich.SandwichBuilder builder = new Sandwich.SandwichBuilder();

            System.out.println("Let's make you a sandwich!");
            builder.setSandwichSize(selectSandwichSize(scanner));
            builder.setBread(addSingleIngredient(scanner, IngredientType.BREAD));

            boolean meatAdded = false;
            boolean cheeseAdded = false;

            List<Ingredient> meats = addMultipleIngredients(scanner, IngredientType.MEAT);
            if (!meats.isEmpty()) {
                builder.addMultipleIngredients(meats);
                meatAdded = true;
            }

            if(meatAdded){
                builder.addIngredient(addSingleIngredient(scanner, IngredientType.EXTRA_MEAT));
            }

            List<Ingredient> cheeses = addMultipleIngredients(scanner, IngredientType.CHEESE);
            if (!cheeses.isEmpty()) {
                builder.addMultipleIngredients(cheeses);
                cheeseAdded = true;
            }

            if(cheeseAdded){
                builder.addIngredient(addSingleIngredient(scanner, IngredientType.EXTRA_CHEESE));
            }

            builder.addMultipleIngredients(addMultipleIngredients(scanner, IngredientType.REGULAR_TOPPING));
            builder.addMultipleIngredients(addMultipleIngredients(scanner, IngredientType.SAUCES));

            sandwich = builder.build();

            System.out.println("Here is your sandwich:");
            displaySandwich(sandwich);
            System.out.println("Do you want to add this sandwich to your cart, rebuild it, or return to the main menu? (Add/Rebuild/Menu)");

            String input = scanner.nextLine();

            if ("add".equalsIgnoreCase(input)) {
                order.addSandwich(sandwich);
                System.out.println("Sandwich added to order!");
                break;
            } else if ("rebuild".equalsIgnoreCase(input)) {
                System.out.println("Rebuilding your sandwich...");
                continue;
            } else if ("menu".equalsIgnoreCase(input)) {
                System.out.println("Returning to main menu...");
                break;
            } else {
                System.out.println("Invalid input. Please type 'Add', 'Rebuild', or 'Menu'.");
            }
        }
    }

    private static void checkout(){
        System.out.println("Thank you for shopping at Janky James! Your receipt is printing out.");

        ReceiptFileManager.writeReceipt(order);

        clearOrder();
    }

    private static SandwichSize selectSandwichSize(Scanner scanner){
        boolean isSelectingSandwichSize = true;

        while(isSelectingSandwichSize){
            System.out.println("What size sandwich would you like?");
            System.out.println("Small, Medium, Large");
            var choice = scanner.nextLine();

            switch(choice.toLowerCase()){
                case "small":
                    return SandwichSize.SMALL;
                case "medium":
                    return SandwichSize.MEDIUM;
                case "large":
                    return SandwichSize.LARGE;
                default:
                    System.out.println("That is not a valid sandwich size try again");
                    break;
            }
        }

        return SandwichSize.SMALL;
    }

    private static List<Ingredient> addMultipleIngredients(Scanner scanner, IngredientType ingredientType){
        List<Ingredient> selectedIngredients = new ArrayList<>();
        displayIngredientsByType(ingredientType);

        while(true){
            System.out.println("Enter the name of the " + ingredientType.toString().toLowerCase() +
                    " you want to add, or type 'done' to finish:");
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("done")) {
                break;
            }

            getValidIngredientChoiceByType(ingredientType, input).ifPresentOrElse(
                    ingredient -> {
                      selectedIngredients.add(ingredient);
                        System.out.println("Adding " + ingredient.getName() + " to your sandwich!");
                    },
                    () -> System.out.println("Not a valid ingredient, try again.")
            );
        }

        return selectedIngredients;
    }

    private static Ingredient addSingleIngredient(Scanner scanner, IngredientType ingredientType){
        while (true) {
            System.out.println("Choose your " + ingredientType.toString().toLowerCase() + ":");
            displayIngredientsByType(ingredientType);
            String choice = scanner.nextLine();

            if("done".equalsIgnoreCase(choice)) {
                System.out.println("No " + ingredientType.toString().toLowerCase() + " selected.");
                return null;
            }

            Optional<Ingredient> ingredient = getValidIngredientChoiceByType(ingredientType, choice);
            if (ingredient.isPresent()) {
                System.out.println("Adding " + ingredient.get().getName() + " to your sandwich!");
                return ingredient.get();
            } else {
                System.out.println("Not a valid choice, try again.");
            }
        }
    }

    private static void clearOrder(){
        order = new Order();
    }

    private static void viewOrder() {
        if (order.getSandwiches().isEmpty() && order.getSideItems().isEmpty()) {
            System.out.println("Your order is currently empty.");
            return;
        }

        System.out.println("\nYour Order Summary:");
        displaySandwichesInOrder();
        displaySideItemsInOrder();
        displayOrderTotal();
    }

    private static void displaySandwichesInOrder() {
        if (!order.getSandwiches().isEmpty()) {
            System.out.println("\nSandwiches:");
            for (Sandwich sandwich : order.getSandwiches()) {
                displaySandwich(sandwich);
                System.out.println("Price: $" + sandwich.getTotalPrice() + "\n");
            }
        }
    }

    private static void displaySideItemsInOrder() {
        if (!order.getSideItems().isEmpty()) {
            System.out.println("Side Items:");
            for (SideItem sideItem : order.getSideItems()) {
                System.out.println(sideItem.getName() + " - $" + sideItem.getPrice());
            }
        }
    }

    private static void displayOrderTotal() {
        BigDecimal total = order.getOrderTotal();
        System.out.println("\nOrder Total: $" + total);
    }

    private static Optional<SideItem> getValidSideItem(String sideItemName) {
        return SideItemLoader.getAllSideItems().stream()
                .filter(x -> x.getName().equalsIgnoreCase(sideItemName))
                .findFirst();
    }

    private static Optional<Ingredient> getValidIngredientChoiceByType(IngredientType ingredientType, String input){
        return IngredientLoader.getIngredientByType(ingredientType).stream().filter(x -> x.getName().toUpperCase().contains(input.toUpperCase())).findFirst();
    }

    private static void displayIngredientsByType(IngredientType ingredientType){
        StringBuilder stringBuilder = new StringBuilder();
        var titleSpace = (screenSize - ingredientType.toString().length()) / 2;

        stringBuilder.append(createDashes(titleSpace)).append(ingredientType.toString()).append(createDashes(titleSpace)).append(System.lineSeparator());
        stringBuilder.append("Name");
        stringBuilder.append(createDashes(35 - "Name".length())); // Adjust the length for "Name"
        stringBuilder.append("Small");
        stringBuilder.append(createDashes(15 - "Small".length())); // Adjust the length for "Small"
        stringBuilder.append("Medium");
        stringBuilder.append(createDashes(15 - "Medium".length())); // Adjust the length for "Medium"
        stringBuilder.append("Large").append(System.lineSeparator());

        for (Ingredient ingredient : IngredientLoader.getIngredientByType(ingredientType)) {
            stringBuilder.append(ingredient.getName())
                    .append(createDashes(35 - ingredient.getName().length()))
                    .append(formatPrice(ingredient.getPrice(SandwichSize.SMALL)))
                    .append(createDashes(15 - formatPrice(ingredient.getPrice(SandwichSize.SMALL)).length()))
                    .append(formatPrice(ingredient.getPrice(SandwichSize.MEDIUM)))
                    .append(createDashes(15 - formatPrice(ingredient.getPrice(SandwichSize.MEDIUM)).length()))
                    .append(formatPrice(ingredient.getPrice(SandwichSize.LARGE)))
                    .append(System.lineSeparator());
        }

        System.out.println(stringBuilder.toString());
    }

    private static String formatPrice(BigDecimal price) {
        return String.format("$%-11.2f", price);
    }

    private static String createDashes(int length) {
        return length > 0 ? String.join("", Collections.nCopies(length, " ")) : "";
    }

    public static void displaySandwich(Sandwich sandwich) {
        if (sandwich == null) {
            System.out.println("No sandwich to display.");
            return;
        }

        System.out.println("\nYour Sandwich Details:");
        System.out.println("Size: " + sandwich.getSandwichSize());

        Map<IngredientType, List<Ingredient>> categorizedIngredients = categorizeIngredients(sandwich.getIngredientList());

        for (IngredientType type : categorizedIngredients.keySet()) {
            System.out.println(type + ": ");
            categorizedIngredients.get(type).forEach(ingredient ->
                    System.out.println(" - " + ingredient.getName() + " ($" + ingredient.getPrice(sandwich.getSandwichSize()) + ")")
            );
        }
    }

    private static Map<IngredientType, List<Ingredient>> categorizeIngredients(List<Ingredient> ingredients) {
        Map<IngredientType, List<Ingredient>> categorized = new HashMap<>();

        for (Ingredient ingredient : ingredients) {
            categorized.computeIfAbsent(ingredient.getIngredientType(), k -> new ArrayList<>()).add(ingredient);
        }

        return categorized;
    }
}
