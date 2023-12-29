class BtPractice{
    public static boolean ratInMaze(int maze[][],int row,int col){
        //base condition
        if(row==-1 || row==maze.length || col==-1 || col==maze.length || maze[row][col]==-1 || maze[row][col]==0){
            return false;
        }
        //recursion
        if(row==maze.length-1 && col==maze.length-1){
            maze[row][col]=-1;
            return true;
        }
        maze[row][col]=-1;
        if(ratInMaze(maze, row, col+1)){
            return true;
        }
        if(ratInMaze(maze, row+1, col)){
            return true;
        }
        if(ratInMaze(maze, row, col-1)){
            return true;
        }
        if(ratInMaze(maze, row-1, col)){
            return true;
        }
        maze[row][col]=1;
        return false;
    }
    public static void convertMaze(int maze[][]){
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze.length;j++){
                if(maze[i][j]==-1){
                    maze[i][j]=1;
                } else {
                    maze[i][j]=0;
                }
            }
        }
    }
    public static void printMaze(int maze[][]){
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze.length;j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
    //rat in maze
    // int maze[][]={
    //     {1,1,1,1,1,1,0},
    //     {0,0,0,0,0,1,0},
    //     {1,1,1,0,0,1,0},
    //     {1,0,1,1,1,1,0},
    //     {1,0,0,0,0,0,0},
    //     {1,1,1,0,0,0,0},
    //     {0,0,1,1,1,1,1}
    // };
    // if(ratInMaze(maze,0,0)){
    //     System.out.println("Solution exist");
    //     convertMaze(maze);
    //     printMaze(maze);
    // } else {
    //     System.out.println("Solution Not exist");
    // }


    public static int check(int total,int r,int b,int k,int n,char last,int pos){
        if(pos==total){
            return 1;
        }
        int choice=0;
        if(pos==0){
            if(r>0)
            choice+=check(total,r-1,b,k,1,'R',pos+1);
            if(b>0)
            choice+=check(total,r,b-1,k,1,'B',pos+1);
            return choice;
        }
        if(last=='B'){
            if(n<k && b>0){
                choice+=check(total,r,b-1,k,n+1,'B',pos+1);
            }
            if(r>0) {
                choice+=check(total,r-1,b,k,1,'R',pos+1);
            }
        } else {
            if(n<k && r>0){
                choice+=check(total,r-1,b,k,n+1,'R',pos+1);
            }
            if(b>0){
                choice+=check(total,r,b-1,k,1,'B',pos+1);
            }
        }
        return choice;
    }
    public static void main(String[] args) {
        System.out.println(check(8, 4, 4, 2, 1, '-', 0));
    }
}