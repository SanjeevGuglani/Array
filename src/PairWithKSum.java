import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sanjeev Guglani
 */
public class PairWithKSum {

    //Pair Sum With duplicate and all
    //coding ninja time complexity
    public static void pairSum(int[] arr, int num){
        Arrays.sort(arr);
        int i=0,j=arr.length-1;
        while(i<j){
            if(arr[i]+arr[j]==num){
                int count=1;
                if(arr[i]==arr[j]){
                    count=((j-i)*(j-i+1))/2;
                    print(arr[i],arr[j],count);
                    i=j+1;
                }else{
                    int temp = i;
                    while(temp<arr.length && arr[temp]==arr[temp+1]){
                        temp++;
                    }
                    int l = temp -i +1;
                    temp = j;
                    while(temp>0 && arr[temp]==arr[temp-1]){
                        temp--;
                    }
                    int r=j-temp+1;
                    count = l*r;
                    print(arr[i],arr[j],count);
                    i=i+l;
                    j=j-r;
                }

            }else if(arr[i]+arr[j]>num){
                j--;
            }else{
                i++;
            }
        }

    }

    public static void pairSum2(int[] arr, int num){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(num-arr[i])){
                print(arr[i],num-arr[i],map.get(num-arr[i]));
            }
            if(!map.containsKey(arr[i])){
                map.put(arr[i],0);
            }
            map.put(arr[i],map.get(arr[i])+1);
        }
    }



    public static void print(int a,int b,int count){
        for(int i=1;i<=count;i++) {
            if (a < b)
                System.out.println(a + " " + b);
            else
                System.out.println(b + " " + a);
        }
    }
}
