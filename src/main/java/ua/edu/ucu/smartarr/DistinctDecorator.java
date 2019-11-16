package ua.edu.ucu.smartarr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray sa){
        super(sa);

    }
    @Override
    public Object[] toArray() {
        ArrayList<Object> fin = new ArrayList<>();
        ArrayList<Object> cur = new ArrayList<>(Arrays.asList(smartArray.toArray()));
        for (int i = 0; i < smartArray.size(); i++) {
            for (int j = i + 1; j < smartArray.size(); j++) {
                if (!(cur.get(i).equals(cur.get(j))) && !fin.contains(cur.get(i))){
                    fin.add(cur.get(i));
                }
            }
        }
        return fin.toArray();
    }

    @Override
    public String operationDescription() {
        return "Distinct" + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
