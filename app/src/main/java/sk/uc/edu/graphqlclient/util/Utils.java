package sk.uc.edu.graphqlclient.util;

import java.util.ArrayList;
import java.util.List;

import sk.uc.edu.graphqlclient.GetTodosQuery;

/**
 * Created by malobicky
 * on 11.3.18.
 * AndroidClient
 */

public class Utils {
    public static List<GetTodosQuery.GetAll> filterData(List<GetTodosQuery.GetAll> getAll) {
        List<GetTodosQuery.GetAll> newList = new ArrayList<>();
        if (getAll != null) {
            for (GetTodosQuery.GetAll item : getAll) {
                if (!item.isFinished()) {
                    newList.add(item);
                }
            }
        }
        return newList;
    }
}
