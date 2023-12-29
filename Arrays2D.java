import java.util.*;
public class Arrays2D{
    public static void printMatrix(int mat[][]){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean searchMatrix(int mat[][],int key){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==key){
                    return true;
                }
            }
        }
        return false;
    }

    public static void printSpiral(int mat[][]){
        int startRow=0;
        int endRow=mat.length-1;
        int startCol=0;
        int endCol=mat.length-1;
        while(startRow<=endRow && startCol<=endCol){
            for(int j=startCol;j<=endCol;j++){
                System.out.print(mat[startRow][j]+" ");
            }
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(mat[i][endCol]+" ");
            }
            for(int j=endCol-1;j>=startCol;j--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(mat[endRow][j]+" ");
            }
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(mat[i][startCol]+" ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        System.out.println();
    }

    public static void staircaseSearch(int mat[][],int key){
        int row=0,col=mat[0].length-1;
        while(row<mat.length && col>=0){
            if(key==mat[row][col]){
                System.out.println("Key Found at ("+row+","+col+")");
                return;
            }
            if(key<mat[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("Key Not Found");
        return;
    }

    public static void main(String[] args) {
        int n,m;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int mat[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        int key;
        System.out.print("Enter Key value:");
        key=sc.nextInt();
        printMatrix(mat);
        staircaseSearch(mat,key);
        
    }
}