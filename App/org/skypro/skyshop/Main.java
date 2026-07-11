package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // создаем продукты, 10 штук
        SimpleProduct prod1 = new SimpleProduct("Апельсин", 174);
        SimpleProduct prod2 = new SimpleProduct("Колбаса", 274);
        SimpleProduct prod3 = new SimpleProduct("Банан", 49);
        DiscountedProduct prod4 = new DiscountedProduct("Икра", 200, 20);
        SimpleProduct prod5 = new SimpleProduct("Вино", 58);
        SimpleProduct prod6 = new SimpleProduct("Яблоко", 24);
        SimpleProduct prod7 = new SimpleProduct("Виноград", 145);
        FixPriceProduct prod8 = new FixPriceProduct("Лапша");
        SimpleProduct prod9 = new SimpleProduct("Арбуз", 56);
        SimpleProduct prod10 = new SimpleProduct("Макароны", 44);

        // добавляем 4 продукта
        ProductBasket prodBasket = new ProductBasket();
        prodBasket.addProduct(prod3);
        prodBasket.addProduct(prod7);
        prodBasket.addProduct(prod3);
        prodBasket.addProduct(prod4);
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