/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marius
 */
public class ExampleLoggerIT {
    
    public ExampleLoggerIT() {
    }

    /**
     * Test of main method, of class ExampleLogger.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ExampleLogger.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of readFirstLine method, of class ExampleLogger.
     */
    @Test
    public void testReadFirstLine() {
        System.out.println("readFirstLine");
        String file = "";
        ExampleLogger.readFirstLine(file);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
