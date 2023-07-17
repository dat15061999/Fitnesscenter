import java.util.HashMap;

public class Cau2 {
    public static void main(String[] args) {
        System.out.println(checkString("agbd","ahbgdc"));
    }
    public static boolean checkString(String s, String t) {
        String[] arr = s.split("");
        String[] arr2 = t.split("");
        HashMap<String,Integer> list1 = new HashMap<>();
        HashMap<String,Integer> list2 = new HashMap<>();
        for (String value : arr) {
            if (list1.containsKey(value)) {
                list1.put(value, list1.get(value) + 1);
            } else {
                list1.put(value, 1);
            }
        }
        for (String value : arr2) {
            if (list2.containsKey(value)) {
                list2.put(value, list2.get(value) + 1);
            } else {
                list2.put(value, 1);
            }
        }
         boolean check = true;
        for (var item : list1.entrySet()) {
            var key = item.getKey();
            check = list2.containsKey(key) ;
        }
        return check;
    }
}
