package ru.job4j.pojo;

public class Shop {

    public Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length - 1; i++) {
          products[i] = products[i + 1];
        }
        products[products.length - 1] = null;

        return products;
    }

    public static void main(String[] args) {
        Product products[] = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Shrimp", 60);
        products[4] = new Product("Pineapple", 1);

        System.out.println("Before delete:");
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println("After delete:");
        Shop shop = new Shop();
        shop.delete(products, 1);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

    }
}
