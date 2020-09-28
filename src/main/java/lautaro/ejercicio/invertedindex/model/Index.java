package lautaro.ejercicio.invertedindex.model;

public interface Index {

    void buildIndex(String... phrases);

    String[] get(String word);
}
