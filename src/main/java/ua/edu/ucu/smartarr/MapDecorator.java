package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    public MyFunction func;

    public MapDecorator(SmartArray sa, MyFunction function) {
        super(sa);
        this.func = function;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> fin = new ArrayList<>();
        for (Object i : smartArray.toArray()) {
            fin.add(func.apply(i));
        }
        return fin.toArray();
    }

    @Override
    public String operationDescription() {
        return "Mapped" + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
