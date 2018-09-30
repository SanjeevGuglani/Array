import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Sanjeev Guglani
 */
public class RainWaterTrapping {

    public static int rainWater(int arr[]){
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else if(stack.peek()<=arr[i]){
                stack.push(arr[i]);
            }
        }
        int leftMax=-1;
        int sum=0,temp;
        for(int i=0;i<arr.length-1;i++){
            temp = Math.min(leftMax,stack.peek())-arr[i];
            if(temp>0){
                sum+=temp;
            }
            leftMax = Math.max(leftMax,arr[i]);
            if(arr[i]==stack.peek()){
                stack.pop();
            }
        }
        return sum;
    }
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        int test = Integer.valueOf(cin.nextLine());
        int len;
        int arr[];
        for(int i=1;i<=test;i++){
            len = cin.nextInt();
            arr = new int[len];
            for(int j=0;j<len;j++){
                arr[j]=cin.nextInt();
            }
            System.out.println(rainWater(arr));
        }

    }
}
