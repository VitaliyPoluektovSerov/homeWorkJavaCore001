package org.skypro.skyshop.Searchable;

public interface Searchable {
    String searchTerm();
    String searchType();
    String getName();

    default String getStringRepresentation() {
          return "Имя объекта: " + searchTerm() + " - Тип объекта: " + searchType();
    }

}
