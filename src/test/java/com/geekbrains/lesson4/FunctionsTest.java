package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static com.geekbrains.lesson4.Functions.isPalindrome;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger("unctionsTest");

    @BeforeAll
    static void beforeAll() {
        logger.info("Метод выполняется 1 раз перед тестом");
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    //TRACE, DEBUG, INFO, WARN, ERROR
    @BeforeEach
    void beforeEach(){
        logger.error("Метод выполняется перед каждым тестом");
       // WebDriver driver = new ChromeDriver();
        //System.out.println("Метод выполняется перед каждым тестом");
    }

    @Test
    @DisplayName("Метод проверки палиндрома с нечетным кол-вом символов, переданного в метод isPalindrome")
    void givenPalindromeWhenCallIsPalindromeMethodThenTrue () {
       assertThat(isPalindrome("1234321")).isTrue();
        //Assertions.assertTrue(result);

    }

    @Test
    @Disabled("выключен")
    @DisplayName("Метод проверки палиндрома с четным кол-вом символов, переданного в метод isPalindrome")
    void palindromeTest () {
        boolean result = isPalindrome("123321");
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }

    @ParameterizedTest
    @Tag("smoke")
    @ValueSource(strings = {"1234321", "123321"})
    void isPalindromeTestWithDataProvider(String word){
        boolean result = isPalindrome(word);
        //Assertions.assertTrue(result);
        Assertions.assertEquals(true, result);
    }


    @ParameterizedTest
    @CsvSource({"123, false", "123321, true"})
    void csvTest(String word, boolean expectedResult){
        boolean actualResult = isPalindrome(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    void afterEach(){
        System.out.println("Метод выполняется после завершения каждого теста");
        //driver.quit();
    }

    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")
    void catEqualAgeTest(Cat cat, Integer age){
        Assertions.assertEquals(cat.getAge(), age);

    }

    private static Stream<Arguments> catAndAgeDataProvider(){
        return Stream.of(
                Arguments.of(new Cat("Мицар", 3), 3),
                Arguments.of(new Cat("Алькор", 2), 2)
        );
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Этот метод будет выполняться один раз после тестов");
    }
}
