package it.dst.formazione.test;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static it.dst.formazione.esercitazione1.Soluzioni_esercitazione.*;


public class Esercitazione1Test {

    @Test
    public void testClassification() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<String, List<Integer>> result = classifyNumbers(input);

        Assert.assertTrue(result.containsKey("Pari"));
        Assert.assertTrue(result.containsKey("Dispari"));
        Assert.assertEquals(Arrays.asList(2, 4, 6), result.get("Pari"));
        Assert.assertEquals(Arrays.asList(1, 3, 5), result.get("Dispari"));
    }

    @Test
    public void testValidInput() {
        Assert.assertTrue(isValidInput("1 2 3 4 -5"));
        Assert.assertFalse(isValidInput("1 2 three 4"));
        Assert.assertFalse(isValidInput("123a"));
    }

    @Test
    public void testCalculateSum() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        Assert.assertEquals(15, calculateSum(input));
    }

}
