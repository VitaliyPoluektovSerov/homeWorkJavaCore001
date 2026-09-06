package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    Map<String, List<Product>> basket = new HashMap();


    public List<Product> deleteProductByName(String name) {
        List<Product> deleteProduct = new LinkedList<>();
        if (name == null || name.isEmpty()) {
            return deleteProduct;
        }
        List<Product> products = basket.get(name);
        if (products == null) {
            return deleteProduct;
        }
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                deleteProduct.add(product);
                iterator.remove();
            }
        }
        if (products.isEmpty()) {
            basket.remove(name);
        }
        return deleteProduct;
    }

    public void addProduct(Product product) {
//        basket.add(product);
        basket.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);

    }


    public int getFullCost() {
//        int fullCost = 0;
//        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
//            List<Product> products = entry.getValue();
//            for (Product product : products) {
//                fullCost += product.getPrice();
//            }
//        }
        return (int) basket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        int fullCost = 0;
//        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
//            List<Product> products = entry.getValue();
//            for (Product product : products) {
//                if (product != null) {
//                    System.out.println(product);
//                    fullCost = fullCost + product.getPrice();
//                }
//            }
//        }
        fullCost = (int) basket.values().stream()
                .flatMap(Collection::stream)
                .peek(System.out::println)
                .mapToInt(Product::getPrice)
                .sum();
        if (fullCost != 0) {
            System.out.println("Итого: " + fullCost);
            System.out.println("Специальных товаров: " + specialProductOfBasket());
        } else {
            System.out.println("в корзине пусто");
        }
    }

    public boolean findProductName(String productName) {
//        boolean check = false;
//        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
//            if (!check) {
//                List<Product> products = entry.getValue();
//                for (Product product : products) {
//                    if (product != null) {
//                        if (productName.equals(product.getName())) {
//                            check = true;
//                            break;
//                        }
//                    }
//                }
//            } else {
//                break;
//            }
//        }
//        return check;
        return basket.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(product -> productName.equalsIgnoreCase((product.getName())));
    }

    public void clearBasket() {
        basket.clear();
    }

    public int specialProductOfBasket() {
//        int isSpecial = 0;
//        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
//            List<Product> products = entry.getValue();
//            for (Product product : products) {
//                if (product != null) {
//                    if (product.isSpecial()) {
//                        isSpecial++;
//                    }
//                }
//            }
//        }
//        return isSpecial;
        return (int) basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

}



