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

    public void buildIndex(String[] phrases){
        invertedIndex.buildIndex(phrases);
    }

    public String[] get(String word){
        if(word == null){
            LOGGER.error("La palabra es null, no se puede buscar en el indice.");
            return null;
        }
        if(word.isEmpty()){
            LOGGER.error("La palabra esta vacia, no se puede buscar en el indice.");
            return null;
        }
        return invertedIndex.get(word);
    }
}
