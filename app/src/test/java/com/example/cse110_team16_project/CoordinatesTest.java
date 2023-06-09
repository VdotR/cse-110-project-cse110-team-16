package com.example.cse110_team16_project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

import com.example.cse110_team16_project.classes.CoordinateClasses.Coordinates;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class CoordinatesTest {
    @Test
    public void testConstructor(){
        Coordinates c = new Coordinates(1.2345,-2.146);
        assertEquals(1.2345,c.first,0.0001);
        assertEquals(-2.146,c.second,0.0001);
    }
    @Test
    public void testBearingTo(){
        Coordinates c = new Coordinates(1,2);
        Coordinates d = new Coordinates(3,2);
        Coordinates e = new Coordinates(3,4);
        assertEquals(0,c.bearingTo(d).getDegrees(),0.30);
        assertEquals(90,d.bearingTo(e).getDegrees(),0.30);
        assertEquals(45,c.bearingTo(e).getDegrees(),0.30);
    }

    @Test
    public void testBearingToAtZeros() {
        Coordinates c = Coordinates.getNullIsland();
        Coordinates d = Coordinates.getNullIsland();
        assertEquals(0,c.bearingTo(d).getDegrees(),0.30);
    }
}