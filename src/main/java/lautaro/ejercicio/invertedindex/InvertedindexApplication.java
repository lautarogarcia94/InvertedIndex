package lautaro.ejercicio.invertedindex;

import lautaro.ejercicio.invertedindex.Controller.IndexController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class InvertedindexApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(InvertedindexApplication.class, args);
        IndexController controller = (IndexController) context.getBean("indexController");

        String[] data = new String[]{
                "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad",
                "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir",
                "Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell",
                "This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith",
                "Another book with music related content",
                ""
        };

        controller.buildIndex(data);

        String[] results = controller.get("muSIc");

        // Debe mostrar 2
        System.out.println(results.length);

        // Debe mostrar [".... music, writes Peter Conrad","Another book with music related ..."]
        System.out.println(Arrays.toString(results));

       /* results = controller.get(null);
        results = controller.get("");
        results = controller.get("aaacccHighfrecuency..");
*/
    }

}
