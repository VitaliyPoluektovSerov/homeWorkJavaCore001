package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return name + "\n" + text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article article)) return false;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String searchType() {
        return "ARTICLE";
    }

    @Override
    public String searchTerm() {
        return toString();
    }
}
