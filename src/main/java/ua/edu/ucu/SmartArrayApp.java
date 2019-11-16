package ua.edu.ucu;

import java.util.ArrayList;
import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate prd = t -> (((Student)t).getYear() == 2 && ((Student)t).getGPA() >= 4);
        MyComparator cmp = (o1, o2) -> (((Student)o1).getSurname().compareTo(((Student)o2).getSurname()));

        SmartArray st_sa = new BaseArray(students);
        st_sa = new DistinctDecorator(st_sa);
        st_sa = new FilterDecorator(st_sa, prd);
        st_sa = new SortDecorator(st_sa, cmp);

        Object[] fin_arr = st_sa.toArray();
        String[] fin_str = new String[st_sa.size()];
        for (int i = 0; i < st_sa.size(); i++) {
            fin_str[i] = String.format("%s %s", ((Student) fin_arr[i]).getSurname(), ((Student) fin_arr[i]).getName());
        }
        // Hint: to convert Object[] to String[] - use the following code
//        Object[] result = studentSmartArray.toArray();
//        return Arrays.copyOf(result, result.length, String[].class);
        return fin_str;
    }
}
