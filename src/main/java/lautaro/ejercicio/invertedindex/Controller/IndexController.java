package lautaro.ejercicio.invertedindex.Controller;


import lautaro.ejercicio.invertedindex.model.Index;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

    private Index invertedIndex;

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(IndexController.class);


    @Autowired
    public void setInvertedIndex(Index invertedIndex) {
        this.invertedIndex = invertedIndex;
    }

    /**
     * Este metodo llama al metodo buildIndex, de la clase InvertedIndex para indexar cada frase
     * del Array con frases que se le pasa por parametro. Antes de intentar indexar cada frase
     * valida que no este vacia o nula.
     *
     * @param phrases Array con frases a indexar
     */
    public void buildIndex(String[] phrases) {
        if (phrases == null) {
            System.out.println("lpm");
            return;
        }
        if (phrases.length == 0) {
            LOGGER.error("La frase a indexar es nula.");
            return;
        }
        for (String phrase : phrases) {
            if (phrase == null) {
                LOGGER.error("La frase a indexar es nula.");
                continue;
            } else if (phrase.isEmpty()) {
                LOGGER.warn("La frase a indexar esta vacia.");
                continue;
            } else {
                invertedIndex.buildIndex(phrase);
                LOGGER.info("Se indexo la frase: " + phrase);
            }
        }
    }


    /**
     * Llama al medoto getSize() del indice invertido.
     *
     * @return int
     */
    public int getSize() {
        return invertedIndex.getSize();
    }

    /**
     * Este metodo llama al metodo get, de la clase InvertedIndex y devuelve el Array con las frases
     * donde aparece la palabra solicitada por parametro. Previamente a realizar la llamada al metodo,
     * valida que la palabra a buscar no sea nula o este vacia, en ese caso loguea un mensaje de error
     * y retorna un null.
     *
     * @param word Palabra a buscar en el indice
     * @return String[] con las frases donde aparece la palabra buscada
     */
    public String[] get(String word) {
        if (word == null) {
            LOGGER.error("La palabra es null, no se puede buscar en el indice.");
            return null;
        }
        if (word.isEmpty()) {
            LOGGER.error("La palabra esta vacia, no se puede buscar en el indice.");
            return null;
        }
        return invertedIndex.get(word);
    }
}
