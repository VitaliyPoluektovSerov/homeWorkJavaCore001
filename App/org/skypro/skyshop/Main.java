package org.skypro.skyshop;

import org.skypro.skyshop.Searchable.SearchEngine;
import org.skypro.skyshop.Searchable.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

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

        SearchEngine search = new SearchEngine(15);
        search.add(prod1);
        search.add(prod2);
        search.add(prod3);
        search.add(prod4);
        search.add(prod5);
        search.add(prod6);
        search.add(prod7);
        search.add(prod8);
        search.add(prod9);
        search.add(prod10);
        Article art1 = new Article("Шапка", "Черная, шерсть, с козырьком");
        Article art2 = new Article("Футболка", "Красная, хлопок");
        Article art3 = new Article("Платье", "Розовой, шелковое, в пол");
        Article art4 = new Article("Майка", "Белая, хлопок");
        Article art5 = new Article("Пальто", "Черное, шерсть, по пояс");
        search.add(art1);
        search.add(art2);
        search.add(art3);
        search.add(art4);
        search.add(art5);

        Searchable[] results = search.search("Лапша");
        System.out.println("Результаты поиска для 'Лапша'");
        for (Searchable element : results) {
            if (element != null) {
                System.out.println(element.getStringRepresentation());
            }
        }

        results = search.search("Пальто");
        System.out.println("Результаты поиска для 'Пальто'");
        for (Searchable element : results) {
            if (element != null) {
                System.out.println(element.getStringRepresentation());
            }
        }

    }
}