package lautaro.ejercicio.invertedindex.Controller;


import lautaro.ejercicio.invertedindex.model.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

    private Index invertedIndex;

    @Autowired
    public void setInvertedIndex(Index invertedIndex) {
        this.invertedIndex = invertedIndex;
    }

    public void buildIndex(String[] phrases){
        invertedIndex.buildIndex(phrases);
    }

    public String[] get(String word){
        return invertedIndex.get(word);
    }
}
