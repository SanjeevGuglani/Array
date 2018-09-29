import java.util.Arrays;

/**
 * Created by Sanjeev Guglani
 */
public class DuplicateInTwoArray {

    public static void intersection(int[] arr1, int[] arr2){

        int temp[];
        if(arr1.length>arr2.length){
            temp = arr1;
            arr1 =arr2;
            arr2=temp;
        }
        Arrays.sort(arr1);
        for(int i=0;i<arr2.length;i++){
            if(Arrays.binarySearch(arr1,arr2[i])>=0){
                System.out.print(arr2[i]);
            }
        }
    }

    public static void intersection1(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]==arr2[j]){
                System.out.println(arr1[i]);
                i++;
                j++;
            }else if(arr1[i]<arr2[j]){
                i++;
            }else{
                j++;
            }
        }
    }
}
