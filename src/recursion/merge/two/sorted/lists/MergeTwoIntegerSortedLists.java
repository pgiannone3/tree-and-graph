package recursion.merge.two.sorted.lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoIntegerSortedLists {

    public static void main(String[] args) {
        var list1 = new ArrayList<>(Arrays.asList(1, 3, 5));
        var list2 = new ArrayList<>(Arrays.asList(1, 4, 5));

        MergeTwoIntegerSortedLists mergeTwoIntegerSortedLists = new MergeTwoIntegerSortedLists();
        System.out.println(mergeTwoIntegerSortedLists.merge(list1, list2));

    }


    public List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        if(list1.isEmpty()) {
            return list2;
        }

        if(list2.isEmpty()) {
            return list1;
        }

        if(list1.get(0) < list2.get(0)) {
            int myEl = list1.get(0);
            List<Integer> l = merge(list1.subList(1, list1.size()), list2);
            l.add(0, myEl);
            return l;
        } else {
            int myEl = list2.get(0);
            List<Integer> l = merge(list1, list2.subList(1, list2.size()));
            l.add(0, myEl);
            return l;
        }

    }

}
