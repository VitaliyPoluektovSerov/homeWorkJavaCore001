package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    List<Product> basket = new LinkedList<>();

    //public ProductBasket() {
    //  this.basket = new Product[5];
    //}

    public List<Product> deleteProductByName(String name) {
        List<Product> deleteProduct = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()){
            Product product = iterator.next();
            if (product.getName().equals(name)){
                deleteProduct.add(product);
                iterator.remove();
            }
        }
    return deleteProduct;
    }

    public void addProduct(Product product) {
        basket.add(product);
    }


    public int getFullCost() {
        int fullCost = 0;
        for (Product e : basket) {
            if (e != null) {
                fullCost = fullCost + e.getPrice();
            }
        }
        return fullCost;
    }

    public void printBasket() {
        int fullCost = 0;
        for (Product e : basket) {
            if (e != null) {
                System.out.println(e);
                fullCost = fullCost + e.getPrice();
            }
        }
        if (fullCost != 0) {
            System.out.println("Итого: " + fullCost);
            System.out.println("Специальных товаров: " + specialProductOfBasket());
        } else {
            System.out.println("в корзине пусто");
        }

    }

    public boolean findProductName(String productName) {
        boolean check = false;
        for (Product e : basket) {
            if (e != null) {
                if (productName.equals(e.getName())) {
                    check = true;
                }
            }
        }
        return check;
    }

    public void clearBasket() {
        for (Product e : basket) {
            if (e != null) {
                e = null;
            }
        }
    }

    public int specialProductOfBasket() {
        int isSpecial = 0;
        for (Product e : basket) {
            if (e != null) {
                if (e.isSpecial()) {
                    isSpecial++;
                }
            }
        }
        return isSpecial;
    }

}



