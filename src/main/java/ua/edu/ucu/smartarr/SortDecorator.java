package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{

    public MyComparator cmp;

    public SortDecorator(SmartArray sa, MyComparator comparator){
        super(sa);
        this.cmp = comparator;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> fin = new ArrayList<>(Arrays.asList(smartArray.toArray()));
        fin.sort(cmp);
        return fin.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sorted" + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
