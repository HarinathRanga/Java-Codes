import java.util.*;
class BackTracking{

    public static void findSubsets(String str,StringBuilder ans,int i){
        //base condition
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        //recursion
        //yes
        findSubsets(str, ans.append(str.charAt(i)), i+1);
        ans.delete(ans.length()-1,ans.length());
        //no
        findSubsets(str,ans,i+1);
    }

    public static void findPermutations(String str,StringBuilder ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String NewStr=str.substring(0,i) + str.substring(i+1);
            findPermutations(NewStr, ans.append(ch));
            int n=ans.length();
            ans.delete(n-1,n);
        }
        //findPermutations("abcd",new StringBuilder(""));
    }
    
    //nQueens
    public static boolean isSafe(char board[][],int row,int col){
        //vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //diag left up
        for(int i=row-1,j=col-1 ; i>=0 && j>=0 ; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diag right up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println("-------- CHESS BOARD --------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void nQueens(char board[][],int row){
        if(row==board.length){
            printBoard(board);
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nQueens(board, row+1);
                board[row][j]='X';
            }
        }
        // int n=5;
        // char board[][]=new char[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         board[i][j]='X';
        //     }
        // }
        //nQueens(board, 0);
    }
    //Sudoku
    public static boolean isSafe(int sudoku[][],int row,int col,int digi){
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digi || sudoku[row][i]==digi){
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digi){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int sudoku[][],int row,int col){
        //base case
        if(row==9 && col==0){
            return true;
        }

        //recursion
        int nextRow=row,nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int i=1;i<=9;i++){
            if(isSafe(sudoku,row,col,i)){
                sudoku[row][col]=i;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }

    public static void printSudoku(int sudoku[][]){
        System.out.println("--------- SUDOKU ---------");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
        // int sudoku[][]={
        //     {0,0,8,0,0,0,0,0,0},
        //     {4,9,0,1,5,7,0,0,2},
        //     {0,0,3,0,0,4,1,9,0},
        //     {1,8,5,0,6,0,0,2,0},
        //     {0,0,0,0,2,0,0,6,0},
        //     {9,6,0,4,0,5,3,0,0},
        //     {0,3,0,0,7,2,0,0,4},
        //     {0,4,9,0,3,0,0,5,7},
        //     {8,2,7,0,0,9,0,1,3}
        // };
        // if(sudokuSolver(sudoku, 0, 0)){
        //     System.out.println("The solution is exist");
        //     printSudoku(sudoku);
        // } else {
        //     System.out.println("The solution not exist");
        // }
    }

    
    public static void main(String[] args) {
        int sudoku[][]={
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
        };
        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("The solution is exist");
            printSudoku(sudoku);
        } else {
            System.out.println("The solution not exist");
        }

    }
}