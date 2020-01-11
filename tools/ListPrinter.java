package tools;

import java.util.*;

public class ListPrinter<T> {

    public void printListOfList(List<List<T>> list) {
        for (List<T> innerList: list) {
            Object[] arr = innerList.toArray();
            System.out.println(Arrays.deepToString(arr));
        }
    }
}