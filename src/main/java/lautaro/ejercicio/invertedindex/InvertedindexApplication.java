package lautaro.ejercicio.invertedindex;

import lautaro.ejercicio.invertedindex.Controller.IndexController;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class InvertedindexApplication {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InvertedindexApplication.class);

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(InvertedindexApplication.class, args);
        IndexController controller = (IndexController) context.getBean("indexController");

        String[] data = new String[]{
                "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad",
                "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir",
                "Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell",
                "This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith",
                "Another book with music related content"
        };
        controller.buildIndex(data);

        LOGGER.info("######################");
        imprimir("music", controller.get("music"));
        LOGGER.info("######################");
        imprimir("pieces", controller.get("pieces"));
        LOGGER.info("######################");
        imprimir("a", controller.get("a"));
        LOGGER.info("######################");
        imprimir("puerta", controller.get("puerta"));

    }


    private static void imprimir(String word, String[] phrases) {
        if (phrases != null) {
            LOGGER.info("La palabra " + word + " aparece en " + phrases.length + " frases"); //Loguea en cuantas frases se encuentra la palabra
            for (int i = 0; i < phrases.length; i++) {
                LOGGER.info("La frase " + (i + 1) + " es: " + phrases[i]);//Loguea cada frase
            }
        } else {
            LOGGER.info("La palabra " + word + " no aparece en el indice");
        }
    }

}
