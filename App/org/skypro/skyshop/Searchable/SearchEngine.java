package org.skypro.skyshop.Searchable;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    Set<Searchable> products;
    private int count;

    public SearchEngine() {
        products = new HashSet<>();
        count = 0;
    }

    public Set searchBestResult(String search) throws BestResultNotFound {
        int maxCount = 0;
        //Searchable bestResult = null;
        Set<Searchable> bestResult = new HashSet<>();
        for (Searchable entry : products) {
            if (entry != null) {
                String term = entry.getName();
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
                    bestResult.add(entry);
                }

            }
        }
        if (bestResult == null || bestResult.isEmpty()) {
            throw new BestResultNotFound(search);
        }
        return bestResult;
    }


    public Set search(String searchTerm) {
//        Set<Searchable> result = new TreeSet<>(new SearchableComparator());
//        for (Searchable searchable : products) {
//            if (searchable.searchTerm().contains(searchTerm)) {
//                result.add(searchable);
//            }
//        }
        Set<Searchable> result = products.stream()
                .filter(products -> products.searchTerm().contains(searchTerm))
                .collect(Collectors.toCollection(()-> new TreeSet<>(new SearchableComparator())));


        return result;
    }

    public static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.getName().compareTo(s2.getName());
        }
    }



    public void add(Searchable product) {
        products.add(product);
    }

    public void getSearchTerm(String search) {

    }

}
