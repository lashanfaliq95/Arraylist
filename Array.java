package com.company;

import java.util.Arrays;


/**
 * E/13/095
 *M.L.Faliq
 */
public class Array {

    private int[] array;
    private int[] temp;

    public int[] getArray() {
        return array;
    }

    public Array() {
        array = new int[0]; //creating a empty array

    }

    public Array(int n) {
        array = new int[n];//creating a array of size n

    }

    public void add(int d) {
        try {                          //this will never happen because the add function adds
            array[array.length] = d;   //the new element to  a bigger array than declared
        } catch (ArrayIndexOutOfBoundsException e) {
            temp = new int[array.length];       //temporary array to store the values

            int size = array.length;

            array = new int[array.length + 1];  //declaring a new array with increased size

            for (int n = 0; n < size; n++) {
                array[n] = temp[n];
            }
            array[size] = d;
        }
    }

    public void add(int index, int d) {//didn't catch the exception
       temp=array;
        int size=array.length+1;
        array=new int[size];
        int i;
        for(i=0;i<index;i++){
            array[i]=temp[i];
        }
         array[index]=d;
        for(i=index+1;i<size;i++){
            array[i]=temp[i-1];
        }
        }



    public void replace(int index, int d) {
        try {
            array[index] = d;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error : The index you requested cannot be found.");

        }

    }

    public int get(int index) {
        try {
            return array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error:The index you requested cannot be found.");//gave a error and returned zero
            return 0;                                                            // as we have to return something        }
    }

    public void remove(int index) {

        try {
            int i;
            temp=array;
            array[index] = 0;  //to get the exception
            array=new int[array.length-1];
            for(i=0;i<index;i++){
                array[i]=temp[i];
            }
            for(i=index+1;i<array.length;i++){
                array[i-1]=temp[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error : The index you requested cannot be found.");
        }
    }

    public boolean isEmpty() {
        if (array.length > 0) {
            return false;
        } else {
            return true;
        }
    }

    public int size() {
        return array.length;
    }

    public boolean contains(int d) {
        for (int n = 0; n < array.length; n++) {
            if (array[n] == d) {
                return true;
            }

        }
        return false;
    }

    public void trimToSIze(int size) {
        try {
            temp = array;
            array = new int[size];
            for (int n = 0; n < size; n++) {
                array[n] = temp[n];      //if the size is larger than the given then temp will
            }                            //run out of indexes so there wil be a exception
        } catch (ArrayIndexOutOfBoundsException e) {
            array = temp;  //since we change above
            System.out.println("The size given is too large");
        }

    }

    public void clear() {
        for (int n = 0; n < array.length; n++) {
            array[n] = 0;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }


}
