/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jj
 */
public class GeneratorTest {

    /**
     * Test of wordGenerator method, of class Generator.
     */
    @Test
    public void testWordGenerator() throws Exception {
        System.out.println("wordGenerator");
        int level = 3;
        Generator instance = new Generator(level);
        int expResult = 8;
        instance.wordGenerator(level);
        int result = instance.getWord().toCharArray().length;
        System.out.println();
        assertEquals(expResult, result);

    }

}
