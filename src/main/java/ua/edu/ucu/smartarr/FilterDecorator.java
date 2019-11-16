package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.function.Predicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    public MyPredicate prd;

    public FilterDecorator(SmartArray sa, MyPredicate prd) {
        super(sa);
        this.prd = prd;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> fin = new ArrayList<>();
        for (Object i : smartArray.toArray()) {
            if (prd.test(i)) {
                fin.add(i);
            }
        }
        return fin.toArray();
    }

    @Override
    public String operationDescription() {
        return "Filtered" + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
