package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] arr;

    public BaseArray(Object[] integers) {
        this.arr = integers;
    }

    @Override
    public Object[] toArray() {
        return arr;
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
