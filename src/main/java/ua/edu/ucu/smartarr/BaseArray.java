package ua.edu.ucu.smartarr;

import java.lang.reflect.Array;
import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] arr;

    public BaseArray(Object[] integers) {
        this.arr = Arrays.copyOf(integers, integers.length);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, arr.length);
    }

    @Override
    public String operationDescription() {
        return "Base array";
    }

    @Override
    public int size() {
        return arr.length;
    }

    public static void main(String[] args) {
        SmartArray a = new BaseArray(new Integer[]{1, 2, 3, 4});
        System.out.print(Arrays.toString(a.toArray()));
    }
}
