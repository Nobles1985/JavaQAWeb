package org.example;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    private static Logger logger = (Logger) LoggerFactory.getLogger(TriangleTest.class);

    @ParameterizedTest
    @CsvSource({"3, 4, 5, 6.0", "5, 5, 8, 12.0"})
    void withCsvSourceTest(int a, int b, int c, double S) throws WrongSideException{
        Triangle triangle = new Triangle();
        Assertions.assertEquals(S, triangle.square(a,b,c));
        logger.info("Тест пройден");
    }

    @Test
    void wrongSideTest() throws WrongSideException{
        Triangle triangle = new Triangle();
        Assertions.assertThrows(WrongSideException.class,() -> triangle.square(-4, 5, 6));
        logger.info("Тест пройден");
    }

    @Test
    void nullSideTest() throws NullSideException{
        Triangle triangle = new Triangle();
        Assertions.assertThrows(NullSideException.class,() -> triangle.square(6, 0, 9));
        logger.info("Тест пройден");
    }

    @Test
    void isNotTriangleTest() throws WrongSideException {
        Triangle triangle = new Triangle();
        Assertions.assertTrue(Double.isNaN(triangle.square(100, 4, 3)));
        logger.info("Тест пройден");
    }
}