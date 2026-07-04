package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] basket;

    public ProductBasket() {
        this.basket = new Product[5];
    }

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                break;
            }
            if (i == basket.length - 1) System.out.println("Невозможно добавить продукт.");
        }
    }

    public int getFullCost() {
        int fullCost = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                fullCost = fullCost + basket[i].getPrice();
            }
        }
        return fullCost;
    }

    public void printBasket() {
        int fullCost = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                System.out.println(basket[i].getName() + ": " + basket[i].getPrice());
                fullCost = fullCost + basket[i].getPrice();
            }
        }
        if (fullCost != 0) {
            System.out.println("Итого: " + fullCost);
        } else {
            System.out.println("в корзине пусто");
        }

    }

    public boolean findProductName(String productName) {
        boolean check = false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                if (productName.equals(basket[i].getName())) {
                    check = true;
                }
            }
        }
        return check;
    }

    public void clearBasket() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                basket[i] = null;
            }
        }
    }

}



