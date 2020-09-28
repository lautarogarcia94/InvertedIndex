package lautaro.ejercicio.invertedindex.model;

public interface Index {

    void buildIndex(String phrase);

    String[] get(String word);

    int getSize();
}
