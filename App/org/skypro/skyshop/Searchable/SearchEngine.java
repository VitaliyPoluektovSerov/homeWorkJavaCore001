package org.skypro.skyshop.Searchable;

public class SearchEngine {
    private Searchable[] products;
    private int count;

    public SearchEngine (int size) {
        products = new Searchable[size];
        count = 0;
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] result = new Searchable[5];
        int foundCount =0;
        for (Searchable element : products) {
            if (element != null && element.searchTerm().contains(searchTerm)) {
                result[foundCount] = element;
                foundCount++;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return result;
    }


    public void add(Searchable product) {
        if (count == products.length) {
            return;
        }
        products[count] = product;
        count++;
    }
}
