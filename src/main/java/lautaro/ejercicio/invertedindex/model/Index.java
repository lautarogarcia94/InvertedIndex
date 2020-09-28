package lautaro.ejercicio.invertedindex.model;

/**
 * Interfaz para implementar la clase InvertedIndex
 */
public interface Index {

    /**
     * Analiza la frase pasada por parametro y actualiza el indice generado en memoria.
     *
     * @param phrase frase a indexar
     */
    void buildIndex(String phrase);

    /**
     * Retorna un Array de String, que contiene todas las frases donde se utilizó la palabra
     * pasada por parametro.
     *
     * @param word palabra a  buscar en el indice
     * @return String[] Array con todas las frases donde se encontro la palabra
     */
    String[] get(String word);

    /**
     * Devuelve un int con el tamaño del indice
     *
     * @return int
     */
    int getSize();
}
