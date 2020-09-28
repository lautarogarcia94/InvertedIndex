package lautaro.ejercicio.invertedindex.Controller;


import lautaro.ejercicio.invertedindex.model.Index;
import lautaro.ejercicio.invertedindex.model.InvertedIndex;
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
        if(phrases == null){
            System.out.println("lpm");
            return;
        }
        if(phrases.length == 0){
            LOGGER.error("La frase a indexar es nula.");
            return;
        }
        for (String phrase: phrases) {
            if(phrase == null){
                LOGGER.error("La frase a indexar es nula.");
                continue;
            } else if( phrase.isEmpty()){
                LOGGER.warn("La frase a indexar esta vacia.");
                continue;
            }else{
                invertedIndex.buildIndex(phrase);
                LOGGER.info("Se indexo la frase: "+phrase);
            }
        }
    }


    public int getSize(){
      return  invertedIndex.getSize();
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
