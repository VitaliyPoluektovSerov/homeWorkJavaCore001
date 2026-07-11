package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // создаем продукты, 10 штук
        Product prod1 = new Product("Апельсин", 174);
        Product prod2 = new Product("Колбаса", 274);
        Product prod3 = new Product("Банан", 49);
        Product prod4 = new Product("Икра", 38);
        Product prod5 = new Product("Вино", 58);
        Product prod6 = new Product("Яблоко", 24);
        Product prod7 = new Product("Виноград", 145);
        Product prod8 = new Product("Лапша", 129);
        Product prod9 = new Product("Арбуз", 56);
        Product prod10 = new Product("Макароны", 44);

        // добавляем 4 продукта
        ProductBasket prodBasket = new ProductBasket();
        prodBasket.addProduct(prod3);
        prodBasket.addProduct(prod7);
        prodBasket.addProduct(prod3);
        prodBasket.addProduct(prod10);
        prodBasket.addProduct(prod8);
        // добавление шестого продукта
        prodBasket.addProduct(prod2);


        // подсчет стоимости корзины и вывод ее в терминал
        System.out.println(prodBasket.getFullCost());

        // печать содержимого корзины
        prodBasket.printBasket();

        // проверка метода проверяющего в корзине по имени
        System.out.println(prodBasket.findProductName("Виноград"));
        System.out.println(prodBasket.findProductName("Виноград-"));

        // очистка корзины
        prodBasket.clearBasket();

        //смотрим на результат
        prodBasket.printBasket();
        System.out.println(prodBasket.getFullCost());
        System.out.println(prodBasket.findProductName("Виноград"));
    }
}