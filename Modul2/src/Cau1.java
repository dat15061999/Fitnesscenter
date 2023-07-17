import java.util.Arrays;

public class Cau1 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,6,8,8};
        System.out.println(getIndex(arr,0, arr.length-1,7));
    }
    public static int getIndex(int[] arr,int left,int right,int key) {
        if (left>right) {
            for ()
        }
        int mid = (right+left)/2;
        if (arr[mid]==key) {
            return mid+1;
        } else if (arr[mid]>key) {
            return getIndex(arr,left, mid-1,key);
        } else
            return getIndex(arr,mid+1,right,key);
        }


    }

