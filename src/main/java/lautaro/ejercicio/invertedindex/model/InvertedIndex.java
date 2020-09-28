package lautaro.ejercicio.invertedindex.model;

import lautaro.ejercicio.invertedindex.Controller.IndexController;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * Esta clase implementa la interfaz Index, para generar un indice invertido en memoria. Para
 * esto utiliza un HashMap cuya key será la palabra a indexar, y el valor es un HashSet que
 * almacena todas las frases donde se utiliza la palabra. *
 */
@Component
public class InvertedIndex implements Index {

    private Map<String, HashSet<String>> wordToDocumentMap;
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexController.class);


    public InvertedIndex() {
        wordToDocumentMap = new HashMap<>();
    }

    /**
     * Este metodo recibe una frase y la añade al indice invertido
     * @param phrase frase a indexar
     */
    @Override
    public void buildIndex(String phrase) {
        String[] words;
            words = getWords(phrase.toLowerCase());
            for (String word : words) {
                addWord(word, phrase);
            }
    }

    /**
     * Recibe un String con una frace, y la convierte en un Array de Strings, donde cada elemento del
     * Array es una palabra diferente. Antes de convertir la frase, remueve todos los caracteres
     * especiales.
     *
     * @param phrase frase a convertir
     * @return String[] Array con las palabras de la frase
     */
    private String[] getWords(String phrase) {
        phrase = phrase.replaceAll("[^A-Za-z0-9\\s]", "").trim();;
        String[] words = phrase.split(" ");
        return words;
    }


    /**
     * Este metodo agrega la palabra pasada por parametro al indice, junto a la frase donde.
     * Para ello verifica si la palabra ya estaba indexada, y le agrega la frase al HashSet
     * correspondiente a la palabra. Si no estuviese indexada la palabra, primero inicializa
     * el HashSet y luego le agrega la frase.
     *
     * @param word palabra a indexar
     * @param phrase frase donde aparece la palabra.
     */
    private void addWord(String word, String phrase) {
        HashSet<String> hashSet = wordToDocumentMap.get(word);
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(phrase);
        wordToDocumentMap.put(word, hashSet);
    }

    /**
     * Este metodo devuelve un Array de Strings, que contiene todas las frases donde aparece la palabra
     * buscada. En caso que la palabra no se encuentre en el indice, devuelve null.
     *
     * @param word palabra a buscar en el indice
     * @return
     */
    @Override
    public String[] get(String word) {
        word = word.trim().toLowerCase().replaceAll("[^A-Za-z0-9\\s]", "");
        HashSet<String> hashSet = wordToDocumentMap.get(word);
        if (hashSet == null) {
            LOGGER.warn("No se encontro referencia a la palabra "+word);
            return null;
        }
        return hashSet.toArray(new String[0]);
    }

    @Override
    public int getSize(){
        if(wordToDocumentMap == null) {
            return 0;
        }
        return wordToDocumentMap.size();
    }
}
