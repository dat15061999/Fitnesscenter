import java.util.Arrays;
import java.util.HashMap;

public class cau3 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 9};
        System.out.println(Arrays.toString(getSum(arr,0,arr.length-1, 11)));
        System.out.println(Arrays.toString(getSum(arr,0,arr.length-1, 5)));

        System.out.println(Arrays.toString(getSum2(arr, 6)));
    }

    public static int[] getSum(int[] arr,int a, int b, int target) {
        int sum =arr[a] + arr[b]  ;
        boolean check = true;
        for (; b >0 ; b--) {
            if (sum == target) {
                return new int[]{a, b};
            } else {
                check = false;
            }
        }
        b = arr.length-1;
        if (!check && a<arr.length-1) return getSum(arr,++a ,b,target);
        return new int[]{-1, -1};
    }
    public static int [] getSum2(int [] arr , int target) {
        int sum ;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length; j++) {
                sum = arr[i] +arr[j];
                if (sum == target) {
                    return new int[] {i,j};
                }
            }
        }
        return null;
    }
}
