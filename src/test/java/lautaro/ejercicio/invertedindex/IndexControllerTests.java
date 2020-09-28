package lautaro.ejercicio.invertedindex;

import lautaro.ejercicio.invertedindex.Controller.IndexController;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class IndexControllerTests {

    @Autowired
    IndexController controller;

    @Test
    void t1_buildIndex_withNullArray() {
        String[] phrases = {null};
        controller.buildIndex(phrases);
        assertEquals(0,controller.getSize());
    }

    @Test
    void t2_buildIndex_withNullParam() {
        controller.buildIndex(null);
        assertEquals(0,controller.getSize());
    }

    @Test
    void t3_buildIndex_withAllEmpty() {
        String[] phrases = {""};
        controller.buildIndex(phrases);
        assertEquals(0,controller.getSize());
    }

    @Test
    void t4_buildIndex_withOneNull() {
        String[] phrases = {null,"Hola, estoy bien"};
        controller.buildIndex(phrases);
        assertEquals(3,controller.getSize());
    }

    @Test
    void t5_buildIndex_withOneEmpty() {
        String[] phrases = {"","Hola, estoy bien"};
        controller.buildIndex(phrases);
        assertEquals(3,controller.getSize());
    }

    @Test
    void t6_get_withNull() {
        assertNull(controller.get(null));
    }

    @Test
    void t7_get_withEmpty(){
    assertNull(controller.get(""));
}

    @Test
    void t8_get_withNoIndexWord() {
        assertNull(controller.get("asdfghjklqwerty"));
    }

    @Test
    void t9_get_withIndexWord() {
        String[] phrase = {"Esto es una prueba"};
        controller.buildIndex(phrase);
        String[] result = controller.get("prueba");
        assertTrue(result[0].equalsIgnoreCase("Esto es una prueba"));
        assertEquals(1,result.length);
    }
}
