package models;

public class Product {

    private static int id;
    private static String name;
    private static String description;
    private static double price;
    private static int category_id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getCategory_id() {
        return category_id;
    }

    //For Post request
    public static Product createProduct(String productName, String productDescription, double productPrice, int productCategoryId) {
        Product product = new Product();
        name = productName;
        description = productDescription;
        price = productPrice;
        category_id = productCategoryId;
        return product;
    }

    //For Put request
    public static Product createProductWithId(int productId, String productName, String productDescription, double productPrice, int productCategoryId) {
        Product product = new Product();
        id = productId;
        name = productName;
        description = productDescription;
        price = productPrice;
        category_id = productCategoryId;
        return product;
    }
}
