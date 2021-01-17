package org.example;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



public class TriangleTest {

    @Disabled(value = "не нужен")
    @ParameterizedTest
    @DisplayName("Площадь треугольника")
    @CsvSource({"3,3,3,3.897114317029974", "7,3,9,8.78564169540279"})
    public void triangleAreaTest(int a, int b, int c, double expected) {
        Logger logger = Logger.getLogger(AppTest.class);
        double pp = (a + b + c) / 2.0;  // полупериметр
        double fact = Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c)); // по формуле Герона
        Assertions.assertEquals(fact, expected);
        logger.info("Результаты вычислений верны.");
    }
}
