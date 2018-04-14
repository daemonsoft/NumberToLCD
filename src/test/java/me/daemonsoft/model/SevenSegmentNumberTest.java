package me.daemonsoft.model;

import static org.junit.Assert.*;

import me.daemonsoft.exceptions.NumberToLCDException;
import org.junit.Test;

public class SevenSegmentNumberTest {

    @Test
    public void testGetSegmentStringHorizontalLevelZero() throws NumberToLCDException {
        SevenSegmentNumber sevenSegmentNumber = new SevenSegmentNumber();
        sevenSegmentNumber.setSize(4);
        assertEquals(" ---- ", sevenSegmentNumber.getSegmentString(6, 0));
    }

    @Test
    public void testGetSegmentStringVerticalLevelOne() throws NumberToLCDException {
        SevenSegmentNumber sevenSegmentNumber = new SevenSegmentNumber();
        sevenSegmentNumber.setSize(4);
        assertEquals("|     ", sevenSegmentNumber.getSegmentString(6, 1));
    }

    @Test
    public void testGetSegmentStringHorizontalLevelTwo() throws NumberToLCDException {
        SevenSegmentNumber sevenSegmentNumber = new SevenSegmentNumber();
        sevenSegmentNumber.setSize(4);
        assertEquals(" ---- ", sevenSegmentNumber.getSegmentString(6, 2));
    }

    @Test
    public void testGetSegmentStringVerticalLevelThree() throws NumberToLCDException {
        SevenSegmentNumber sevenSegmentNumber = new SevenSegmentNumber();
        sevenSegmentNumber.setSize(4);
        assertEquals("|    |", sevenSegmentNumber.getSegmentString(6, 3));
    }

    @Test
    public void testGetSegmentStringHorizontalLevelFour() throws NumberToLCDException {
        SevenSegmentNumber sevenSegmentNumber = new SevenSegmentNumber();
        sevenSegmentNumber.setSize(4);
        assertEquals(" ---- ", sevenSegmentNumber.getSegmentString(6, 4));
    }
}