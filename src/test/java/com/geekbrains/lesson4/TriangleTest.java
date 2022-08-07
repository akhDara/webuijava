package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger("unctionsTest");
    @BeforeAll
    static void beforeAll() {
        logger.info("Метод выполняется 1 раз перед тестом");
    }
    @BeforeEach
    void beforeEach() {
        logger.info("Мимо пробежали котики, а вы и не заметили");
    }
    @Test
    @DisplayName(" Метод проверки расчетов по формуле")
    void getAreaTest() throws AreaOfTriangleException {
       assertEquals(Triangle.evaluateArea(3, 7, 9), 9.5, 8.786);
           logger.info("тест пройден");
    }

    @Test
    @DisplayName("Проверка ошибки")
    void getAreaNegativeTest() {
        Assertions.assertThrows(AreaOfTriangleException.class, () -> Triangle.evaluateArea(-5, 7, 0));
        logger.info("Попадет на ошибку");
    }
}
