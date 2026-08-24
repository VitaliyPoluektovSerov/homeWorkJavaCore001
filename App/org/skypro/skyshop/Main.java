package org.skypro.skyshop;

import org.skypro.skyshop.Searchable.SearchEngine;
import org.skypro.skyshop.Searchable.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.List;

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
        try {
            SimpleProduct prod11 = new SimpleProduct("    ", 66);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            SimpleProduct prod11 = new SimpleProduct("Продукт ", -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            DiscountedProduct prod11 = new DiscountedProduct("Икра", 200, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }


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

        System.out.println("проверка метода проверяющего в корзине по имени");
        System.out.println(prodBasket.findProductName("Виноград"));
        System.out.println(prodBasket.findProductName("Виноград-"));

        // очистка корзины
        prodBasket.clearBasket();

        //смотрим на результат
        prodBasket.printBasket();
        System.out.println(prodBasket.getFullCost());
        System.out.println(prodBasket.findProductName("Виноград"));

        SearchEngine search = new SearchEngine();
        search.add(prod1);
        search.add(prod1);
        search.add(prod2);
        search.add(prod2);
        search.add(prod3);
        search.add(prod3);
        search.add(prod4);
        search.add(prod4);
        search.add(prod5);
        search.add(prod5);
        search.add(prod6);
        search.add(prod6);
        search.add(prod6);
        search.add(prod7);
        search.add(prod7);
        search.add(prod8);
        search.add(prod8);
        search.add(prod9);
        search.add(prod9);
        search.add(prod10);
        search.add(prod10);
        Article art1 = new Article("Шапка", "Черная, шерсть, с козырьком");
        Article art2 = new Article("Футболка", "Красная, хлопок");
        Article art3 = new Article("Платье", "Розовой, шелковое, в пол");
        Article art4 = new Article("Майка", "Белая, хлопок");
        Article art5 = new Article("Пальто", "Черное, шерсть, по пояс");
        search.add(art1);
        search.add(art1);
        search.add(art2);
        search.add(art2);
        search.add(art3);
        search.add(art3);
        search.add(art4);
        search.add(art4);
        search.add(art5);
        search.add(art5);

        try {
            Searchable result = search.searchBestResult("Ма");
            System.out.println("Результаты поиска для 'Ма': " + result);
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

        try {
            Searchable result = search.searchBestResult("Футо");
            System.out.println("Результаты поиска для 'Футо': " + result);
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }


        System.out.println("Демонстрация удаления из карзины.");
        System.out.println("-----   Корзина до удаления");
        prodBasket.printBasket();
        System.out.println("-----   список удаленных");
        List<Product> deleteProducts001 = prodBasket.deleteProductByName("Банан");
        if (deleteProducts001.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удалённые продукты:" + deleteProducts001);
        }
        System.out.println("-----   Корзина после удаления");
        prodBasket.printBasket();
        System.out.println("-----   удаляем не существующий");
        List<Product> deleteProducts002 = prodBasket.deleteProductByName("ББББ");
        if (deleteProducts002.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удалённые продукты:" + deleteProducts002);
        }

        System.out.println("ищем вхождение в наименование продуктов ин - и выводим отсортированными значениями" + search.search("ин").values());
    }
}