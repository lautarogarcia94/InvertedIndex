package lautaro.ejercicio.invertedindex.model;

import java.util.HashSet;
import java.util.Map;

public class InvertedIndex implements Index {

    private Map<String, HashSet<String>> wordToDocumentMap;

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
        HashSet<String> hashSet = wordToDocumentMap.get(word);
        return hashSet.toArray(new String[0]);
    }
}
