import java.util.*;
public class twoDarrays {
    public static Scanner s=new Scanner(System.in);
    public static void main(String[] args){
        //creatingArray();
        spiralMatrix();
        diagonalSum();
        stairCaseSearch();
        number();
        sumofnumbersin2ndrow();
        transpose();
    }
    public static void creatingArray(){
        int [][]arr=new int[2][2];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j]=s.nextInt();
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void search(int [][]arr,int key){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] == key){
                    System.out.println("key found at "+i+" "+j);
                    break;
                }
            }
        }
    }
    public static void largestAndSmallest(int [][]arr){
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(largest < arr[i][j]){
                    largest=arr[i][j];
                }
                if(smallest > arr[i][j]){
                    smallest=arr[i][j];
                }
            }
        }
        System.out.println("largest : "+largest+" smallest : "+smallest);
    }
    public static void spiralMatrix(){
        int [][]arr={
                    {1,2,3},
                    {2,3,6},
                    {2,3,1}
                };
        int startrow=0;
        int endrow=arr.length-1; 
        int startcol=0;
        int endcol=arr[0].length-1;
        while(startrow <= endrow && startcol <= endcol){
            //top
            for(int i=startcol;i<=endcol;i++){
                System.out.print(arr[startrow][i]+" ");
                System.out.println("top");
            }
            //right
            for(int i=startrow+1;i<=endrow;i++){
                System.out.print(arr[i][endcol]+" ");
                System.out.println("right");
            }
            //bottom
            for(int i=endcol-1;i>=startcol;i--){
                if(startrow == endrow){
                    break;
                }
                System.out.print(arr[endrow][i]+" ");
                System.out.println("bottom");
            }
            //left
            for(int i=endrow-1;i>startrow;i--){
                if(startcol == endcol){
                    break;
                }
                System.out.print(arr[startcol][i]+" ");
                System.out.println("left");
            }
            startrow++;
            endrow--;
            startcol++;
            endcol--;
            System.out.println();
        }
    }
    public static void diagonalSum(){
        int [][]arr={
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int sum=0;
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;i++){
        //         if(i == j){
        //             sum+=arr[i][j];
        //         }
        //we will add the i/2 and j/2 sum twice 
        //         else if(i+j == arr.length -1 ){
        //             sum+=arr[i][j];
        //         }
        //     }
        // }
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
            if(i != arr.length-1-i){
                sum+=arr[i][arr.length-1-i];
            }
        }
        System.out.println(" sum of all diagonal elements is "+sum);
    }
    public static void stairCaseSearch(){
        int [][]arr={
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int key=12;
        int row=0;
        int col=arr.length-1;
        while(row <= arr.length-1 &&col >= 0 ){
            if(key == arr[row][col]){
                System.out.println("key found at ("+row+" , "+col+")");
                break;
            }else if(key < arr[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        if(key !=arr[arr.length-1][0]){
            System.out.println("key not found");
        }
    }
    public static void number(){
        int key=7;
        int [][]arr={
            {4,7,6,7,7},
            {1,8,7,7,7},
            {1,4,7,7,7},
            {2,7,7,7,7},
            {7,7,7,7,7}
        };
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(key == arr[i][j]){
                    count++;
                }
            }
        }
        System.out.println("the no of "+key+" in the matrix is "+count);
    }
    public static void sumofnumbersin2ndrow(){
        int [][]arr={
            {1,4,9},
            {11,4,3},
            {2,2,3}
        };
        int i=1;
        int sum=0;
        int j=0;
        while(i==1 && j<arr[0].length){
            sum+=arr[1][j];
            j++;
        }
        sum=0;
        j=0;
        for(i=1;i == 1 && j<arr[0].length ;j++ ){
            sum+=arr[1][j];
        }
        System.out.println("sum is "+sum);
    }
    public static void transpose(){
        int [][]arr={
            {123},{147}
        };
        int rows=2;
        int cols=3;
        int [][]transpose=new int[cols][rows];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print("sdfa , ");
                transpose[j][i]=arr[i][j];
            }
        }
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                System.out.print(transpose[i][j]+" ");
            }
            System.out.println();
        }
    }
}
