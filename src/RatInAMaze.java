/**
 * Created by Sanjeev Guglani
 */

public class RatInAMaze {

    public static void ratInAMaze(int maze[][]){
        int res[][]=new int[maze.length][maze[0].length];
        ratInAMaze(maze,0,0,res);
    }

    public static void ratInAMaze(int arr[][],int i,int j,int res[][]){
        if(i<0 || j<0 ||i>=arr.length||j>=arr[i].length || arr[i][j]==0 || res[i][j]==1){
            return;
        }else if(arr[i][j]==1){
            res[i][j]=1;
            if(i==res.length-1 && j==res[i].length-1){
                printSolution(res);
                return;
            }

            int new_res[][]=new int[arr.length][arr[0].length];
            copyArray(res,new_res);
            ratInAMaze(arr,i+1,j,new_res);
            new_res=new int[arr.length][arr[0].length];
            copyArray(res,new_res);
            ratInAMaze(arr,i,j+1,new_res);
            new_res=new int[arr.length][arr[0].length];
            copyArray(res,new_res);
            ratInAMaze(arr,i-1,j,new_res);
            ratInAMaze(arr,i,j-1,res);
        }

    }

    //BETTER
    public static void ratInAMaze2(int arr[][],int i,int j,int res[][]){
        if(i<0 || j<0 ||i>=arr.length||j>=arr[i].length || arr[i][j]==0 || res[i][j]==1){
            return;
        }else if(arr[i][j]==1){
            res[i][j]=1;
            if(i==res.length-1 && j==res[i].length-1){
                printSolution(res);
                res[i][j]=0;
                return;
            }

            ratInAMaze(arr,i+1,j,res);
            ratInAMaze(arr,i,j+1,res);
            ratInAMaze(arr,i-1,j,res);
            ratInAMaze(arr,i,j-1,res);
            res[i][j]=0;
        }

    }


    private static void copyArray(int matrix[][],int myInt[][]){
        for(int i = 0; i< matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                myInt[i][j] = matrix[i][j];
            }
        }

    }
    private static void printSolution(int[][] solution) {
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[][]={{1,0,1},{1,0,1},{1,1,1}};
        ratInAMaze(arr);
    }
}
