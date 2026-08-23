package org.skypro.skyshop.Searchable;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    TreeMap<String, Searchable> products;
    private int count;

    public SearchEngine() {
        products = new TreeMap<>();
        count = 0;
    }

    public Searchable searchBestResult(String search) throws BestResultNotFound {
        int maxCount = 0;
        Searchable bestResult = null;
        for (Map.Entry<String, Searchable> entry : products.entrySet()) {
            Searchable product = entry.getValue();
            if (product != null) {
                String term = product.searchTerm();
                int count = 0;
                int index = 0;
                int indexSubstring = term.indexOf(search, index);
                while (indexSubstring != -1) {
                    count++;
                    index = indexSubstring + search.length();
                    indexSubstring = term.indexOf(search, index);
                }
                if (count > maxCount) {
                    maxCount = count;
                    bestResult = product;
                }

            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound(search);
        }
        return bestResult;
    }


    public List<Searchable> search(String searchTerm) {
        List<Searchable> result = new LinkedList<>();
        for (Map.Entry<String, Searchable> e : products.entrySet()) {
            if (e.getKey().contains(searchTerm)) {
                result.add(e.getValue());
            }
        }
        return result;
    }


    public void add(Searchable product) {
        products.put(product.searchTerm(), product);
    }

    public void getSearchTerm(String search) {

    }

}
