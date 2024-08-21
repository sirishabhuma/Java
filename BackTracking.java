public class BackTracking {
    static int count=0;
    public static void main(String[] args) {
        int []arr=new int[5];
        printArray(arr);
        onArray(arr,0);
        printArray(arr);
        subSets("abc","",0);
        System.out.println();
        permutation("abc","");
        char [][]chessboard=new char[4][4];
        for(int i=0;i<chessboard.length;i++){
            for(int j=0;j<chessboard.length;j++){
                chessboard[i][j]='.';
            }
        }
        nQueens(chessboard,0);
        System.out.println("no of ways to place queens are : "+count);
        System.out.println(gridWays(0,0,4,4));
        int [][]sudoku={
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
        if(sudokuSolver(sudoku,0,0)){
            printSudoku(sudoku);
        }else{
            System.out.println("no solution");
        }
        int [][]ratmaze={
            {1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}
        };
        int [][]sol=new int[ratmaze.length][ratmaze.length];
        System.out.println(ratMaze(ratmaze,0,0,sol));
    }
    public static void printSudoku(int [][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void printArray(int []arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void onArray(int []arr,int index){
        if(index == arr.length){
            return ;
        }
        arr[index]=index+1;
        onArray(arr,index+1);
        arr[index]=index-1;
    }
    public static void subSets(String str,String ans,int i){
        //base case for
        if(i == str.length()){
            if(ans.length()!=0){
                System.out.print(ans + "  ");
            }else{
                System.out.print("null");
            }
            return;
        }
        //recursion
        //yes
        subSets(str,ans+str.charAt(i),i+1);
        //no
        subSets(str,ans,i+1);
    }
    public static void permutation(String str,String ans){
        if(0 == str.length()){
            System.out.print(ans+" ");
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String newStr=str.substring(0,i)+str.substring(i+1);
            permutation(newStr,ans+curr);
        }
    }
    //nqueens
    public static void nQueens(char [][]board,int row){
        if(board.length == row){
            printBoard(board);
            count++;
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(board,row,i)){
                board[row][i]='Q';
                nQueens(board,row+1);
                board[row][i]='.';
            }
        }
    }
    public static boolean isSafe(char [][]board,int row,int col){
        //vertical
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonal left
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //diagonal right
        for(int i=row-1,j=col+1; i>=0 && j<board.length ;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char [][]board){
        System.out.println("---chess board---");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int gridWays(int rows,int cols,int n,int m){
        //base
        if(rows == n || cols == m){
            return 0;
        }else if(rows == n-1 && cols == m-1){
            return 1;
        }
        //work
        int a=gridWays(rows+1,cols,n,m);
        int b=gridWays(rows,cols+1,n,m);
        return a+b;
    } 
    public static boolean sudokuSolver(int [][]sudoku,int rows,int cols){
        //base case
        if(rows >8  && cols ==0){
            return true;
        }
        //recursion
        int nextRow=rows;
        int nextCol=cols+1;
        if(nextCol == 9){
            nextRow=rows+1;
            nextCol=0;
        }
        if(sudoku[rows][cols] !=0){
            return sudokuSolver(sudoku,nextRow,nextCol);
        }
        for(int digit=1;digit <=9;digit++){
            if(isSafe1(sudoku,rows,cols,digit)){
                sudoku[rows][cols] = digit;
                if(sudokuSolver(sudoku,nextRow,nextCol)){
                    return true;
                }
                sudoku[rows][cols] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe1(int [][]sudoku,int rows,int cols,int digit){
        //coloumn
        for(int i=0;i<=8;i++){
            if(sudoku[i][cols]== digit){
                return false;
            }
        }
        //row
        for(int i=0;i<=8;i++){
            if(sudoku[rows][i] == digit){
                return false;
            }
        }
        //grid
        int startrow=(rows/3)*3;
        int startcol=(cols/3)*3;
        
        for(int i=startrow;i<startrow+3;i++){
            for(int j=startcol;j<startcol+3;j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean ratMaze(int [][]maze,int rows,int cols,int [][]sol){
        //base
        if(rows == maze.length-1 && cols ==maze.length-1){
            sol[rows][cols]=1;
            printSudoku(sol);
            return true;
        }
        //recursion
        if(isSafe2(maze,rows,cols)){
            sol[rows][cols]=1;
            if(ratMaze(maze,rows+1,cols,sol)){
                return true;
            }
            if(ratMaze(maze,rows,cols+1,sol)){
                return true;
            }
            sol[rows][cols]=0;
        }
        return false;
    }
    public static boolean isSafe2(int [][]maze,int rows,int cols){
        if(rows <=maze.length-1 && cols <=maze.length-1 && maze[rows][cols]==1){
            return true;
        }
        return false;
    }
    
}
