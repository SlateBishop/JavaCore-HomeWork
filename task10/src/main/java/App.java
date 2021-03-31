import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {
        App app = new App();
        String[] arr = {"aa", "bb", "cc", "dd", "ee", "ff", "aa", "aa", "bb", "qq"};
        LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
        System.out.println(list);
        app.uniqueElementsOfLinkedList(list);
    }

//    public ArrayList<String> arrToArrayList(String[] arr) {
//        ArrayList<String> list = new ArrayList<>(arr.length);
//        for (int i = 0; i < arr.length; i++) {
//            list.add(arr[i]);
//        }
//        return list;
//    }

    public void uniqueElementsOfLinkedList(LinkedList<String> list) {
        LinkedList<String> list2 = new LinkedList<>(list);
        while (list2.size() > 0) {
            Iterator<String> iter = list2.iterator();
            int count = 0;
            String str = list2.get(0);
            while (iter.hasNext()) {
                String thisElement = iter.next();
                if (thisElement.equals(str)) {
                    iter.remove();
                    count++;
                }
            }
            System.out.printf("Элемент \"%s\" встретился %d раз\n", str, count);
        }

    }

}
