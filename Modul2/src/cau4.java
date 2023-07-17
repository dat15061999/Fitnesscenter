import java.util.Arrays;



public class cau4 {
    public static void main(String[] args) {
        String arr = "helalo";
        String arr2 = "leetcoode";
        System.out.println(swap(arr));
        System.out.println(swap(arr2));
    }
    public static String swap(String s) {
        String[] arr = s.split("");
        int count = arr.length-1;
        for (int i =0 ; i < arr.length/2 ; i++) {
            if (arr[i].equals("e") || arr[i].equals("o") || arr[i].equals("u") || arr[i].equals("i") || arr[i].equals("a")) {
                for (int j = count ; j > 0 ; j--) {
                    if (arr[j].equals("e") || arr[j].equals("o") || arr[j].equals("u") || arr[j].equals("i") || arr[j].equals("a")) {
                        String temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                        count = count-1;
                    }
                }
            }
        }
        return String.join("",arr);
    }
}
