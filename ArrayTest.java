package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.internal.BooleanSupplier;

import static org.junit.Assert.*;

/**
 * E/13/095
 *M.L.Faliq
 */
public class ArrayTest {
    Array a;//cant declare before after because we need different cases


    @Test
    public void addWhenArrayIsNotEmpty() throws Exception {
        a = new Array(5);
        a.add(7);
        int[] expected = a.getArray();
        int[] actual = {0, 0, 0, 0, 0, 7};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addWhenArrayIsEmpty() throws Exception {
        a = new Array();
        a.add(7);
        int[] expected = a.getArray();
        int[] actual = {7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void add1WhenArrayIsNotEmpty() throws Exception {//when empty i let the exception take its course
        a = new Array(5);
        a.add(3, 7);
        int[] expected = a.getArray();
        int[] actual = {0, 0, 0, 7, 0, 0};
        assertArrayEquals(expected, actual);
    }


    @Test
    public void replaceWhenArrayIsNotEmpty() throws Exception {
        a = new Array(5);
        a.replace(2, 5);
        int[] expected = a.getArray();
        int[] actual = {0, 0, 5, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void replaceWhenArrayIsEmpty() throws Exception {
        a = new Array();
        a.replace(2, 5);
        int[] expected = a.getArray();          //here you don't change your array you just replace the elements with given
        int[] actual = {};   //so if it empty nothing should be done,i give a error report during runtime
        assertArrayEquals(expected, actual);
    }

    @Test
    public void replaceWhenArrayIndexIsOutOfBound() throws Exception {
        a = new Array(5);
        a.replace(5, 5);
        int[] expected = a.getArray(); //here again i give a error report during runtime and the
        int[] actual = {0, 0, 0, 0, 0};       //array doesn't change
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getWhenArrayIsNotEmpty() throws Exception {
        a = new Array(2);
        a.add(5);
        int expected = 5;
        int actual = a.get(2);
        assertEquals(expected, actual);
    }

    @Test
    public void getWhenArrayIsEmpty() throws Exception {
        a = new Array();

        int expected = 0;          // i give a error report when index is out of bound
        int actual = a.get(1);   // and as it has a return type i give zero
        assertEquals(expected, actual);
    }

    @Test
    public void getWhenArrayIndexIsOutOfBound() throws Exception {
        a = new Array(5);
        int expected = 0;     // i give 0 and a error report when there is a exception to show there is a error
        int actual = a.get(5);
        assertEquals(expected, actual);
    }

    @Test
    public void removeWhenArrayIsNotEmpty() throws Exception {
        a = new Array(5);
        a.replace(1, 5);
        a.replace(3, 6);
        a.remove(1);
        int[] expected = a.getArray();
        int[] actual = {0, 0, 6, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeWhenArrayIsEmpty() throws Exception {
        a = new Array();
        a.remove(1);
        int[] expected = a.getArray();        //i give a error during the exception
        int[] actual = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeWhenArrayIndexIsOutOfBound() throws Exception {
        a = new Array(5);
        a.replace(1, 5);
        a.replace(3, 6);
        a.remove(5);
        int[] expected = a.getArray();  //i give a error during exception
        int[] actual = {0, 5, 0, 6, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void isEmptyTrue() throws Exception {
        a = new Array();
        Boolean expected = true;
        Boolean actual = a.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void isEmptyFalse() throws Exception {
        a = new Array(5);
        Boolean expected = false;
        Boolean actual = a.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void sizeWhenNotEmpty() throws Exception {
        a = new Array(5);

        int expected = 5;
        int actual = a.size();
        assertEquals(expected, actual);
    }

    @Test
    public void sizeWhenEmpty() throws Exception {
        a = new Array();

        int expected = 0;
        int actual = a.size();
        assertEquals(expected, actual);
    }

    @Test
    public void containsTrue() throws Exception {
        a = new Array(5);
        a.replace(1, 5);
        a.replace(3, 6);
        Boolean expected = true;
        Boolean actual = a.contains(5);
        assertEquals(expected, actual);
    }

    @Test
    public void containsFalse() throws Exception {
        a = new Array(5);
        a.replace(1, 5);
        a.replace(3, 6);
        Boolean expected = false;
        Boolean actual = a.contains(7);
        assertEquals(expected, actual);
    }

    @Test
    public void trimToSIzeWhenNotEmpty() throws Exception {
        a = new Array(5);
        a.replace(2, 5);
        a.trimToSIze(4);
        int[] expected = a.getArray();

        int[] actual = {0, 0, 5, 0};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void trimToSIzeWhenEmpty() throws Exception {
        a = new Array();
        a.trimToSIze(5);
        int[] expected = a.getArray();

        int[] actual = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void trimToSIzeWhenArrayIndexIsOutOfBound() throws Exception {
        a = new Array(5);
        a.replace(2, 5);
        a.trimToSIze(6);
        int[] expected = a.getArray();  //no change is done to the array when the given size is bigger,
        // the exception is caught and a error report is given
        int[] actual = {0, 0, 5, 0, 0};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void clearWhenNotEmpty() throws Exception {
        a = new Array(5);
        a.replace(0, 1);
        a.replace(2, 2);
        a.replace(4, 3);
        a.clear();
        int[] expected = a.getArray();
        int[] actual = {0, 0, 0, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void clearWhenEmpty() throws Exception {
        a = new Array();

        a.clear();
        int[] expected = a.getArray();
        int[] actual = {};
        assertArrayEquals(expected, actual);
    }
}