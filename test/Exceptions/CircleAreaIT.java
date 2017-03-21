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
public class CircleAreaIT {
    
    public CircleAreaIT() {
    }

    /**
     * Test of main method, of class CircleArea.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CircleArea.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of circleArea method, of class CircleArea.
     */
    @Test
    public void testCircleArea() throws Exception {
        System.out.println("circleArea");
        double radius = 0.0;
        double expResult = 0.0;
        double result = CircleArea.circleArea(radius);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
