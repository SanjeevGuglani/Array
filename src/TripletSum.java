import java.util.Arrays;

/**
 * Created by Sanjeev Guglani
 */

public class TripletSum {

    public static void FindTriplet(int[] arr, int x){
        Arrays.sort(arr);
        for(int k=0;k<arr.length-2;k++){
            int i=k+1,j=arr.length-1;
            int num = x-arr[k];
            while(i<j){
                if(arr[i]+arr[j]==num){
                    int count=1;
                    if(arr[i]==arr[j]){
                        count=((j-i)*(j-i+1))/2;
                        print(arr[k],arr[i],arr[j],count);
                        i=j+1;
                    }else{
                        int temp = i;
                        while(temp<arr.length && arr[temp]==arr[temp+1]){
                            temp++;
                        }
                        int l = temp -i +1;
                        temp = j;
                        while(temp>k && arr[temp]==arr[temp-1]){
                            temp--;
                        }
                        int r=j-temp+1;
                        count = l*r;
                        print(arr[k],arr[i],arr[j],count);
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
    }
    public static void print(int c,int a,int b,int count){
        for(int i=1;i<=count;i++)
            System.out.println(c+" "+a+" "+b);
    }
}
