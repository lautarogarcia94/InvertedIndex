package lautaro.ejercicio.invertedindex.model;

import lautaro.ejercicio.invertedindex.Controller.IndexController;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Component
public class InvertedIndex implements Index {

    private Map<String, HashSet<String>> wordToDocumentMap;
    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexController.class);


    public InvertedIndex() {
        wordToDocumentMap = new HashMap<>();
    }

    @Override
    public void buildIndex(String... phrases) {
        String[] words;
        for (String phrase : phrases) {
            words = getWords(phrase);
            for (String word : words) {
                addWord(word, phrase);
            }
        }
    }

    private String[] getWords(String phrase) {
        phrase = phrase.trim();
        phrase = phrase.replaceAll("[^A-Za-z0-9\\s]", "");
        String[] words = phrase.split(" ");
        return words;
    }

    private void addWord(String word, String phrase) {
        HashSet<String> hashSet = wordToDocumentMap.get(word);
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(phrase);
        wordToDocumentMap.put(word, hashSet);
    }

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
}
