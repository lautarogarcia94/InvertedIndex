package lautaro.ejercicio.invertedindex;

import lautaro.ejercicio.invertedindex.Controller.IndexController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InvertedindexApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(InvertedindexApplication.class, args);
        IndexController controller = (IndexController) context.getBean("indexController");
    }

}
