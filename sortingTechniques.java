  //import java.util.*;
public class sortingTechniques {
    
    public static void main(String[] args){
        int []arr={1,2,3,4,5,6,7,8,9};
        System.out.println("Bubble sort");
        printArray(arr);
        printArray(bubbleSort(arr));
        System.out.println("Selection sort");
        //printArray(arr);
        //printArray(selectionSort(arr));
        System.out.println("insertion sort");
        //printArray(arr);
        //printArray(insertionSort(arr));
        System.out.println("inbuilt sort ");
        //inBuiltSort();
        System.out.println("counting sort");
        //countingSort(arr);
        //printArray(arr);
        //bubbleSort1();
        //insertionSort1();
        //SelectionSort1();
        // countinSort1();

    }
    public static int[] bubbleSort(int []arr){
        for(int i=0;i<arr.length-1;i++){
            boolean swapped=false;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1] ){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    swapped=true;
                }
            }
            if(swapped==false){
                break;
            }
        }
        return arr;
    }
    public static void printArray(int []arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
    public static int[] selectionSort(int []arr){
        int swaps=0;
        for(int i=0;i<arr.length-1;i++){
            int minpos=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minpos] > arr[j] ){
                    minpos=j;
                }
            }
            int temp=arr[minpos];
            arr[minpos]=arr[i];
            arr[i]=temp;
            swaps++;
        }
        System.out.println(swaps);
        return arr;
    }
    public static int[] insertionSort(int []arr){
        for(int i=1;i<arr.length;i++){
            int cur=arr[i];
            int prev=i-1;
            while(prev >=0 && arr[prev] > cur){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=cur;
        }
        return arr;
    }
    public static void inBuiltSort(){
        //int []arr={3,6,9,8,5,2,1,4,7};
        //printArray(arr);
        //Arrays.sort(arr);
        //printArray(arr);
        //the time complexity of inbuilt sort of java is nlogn
        //we can specify the startig and ending index value left
        //Arrays.sort(arr,1,arr.length-2);
        //printArray(arr);
        //to sort an array in reverse order we have to use collections 
        //Arrays.sort(arr,Collections.reverseOrder());
        //printArray(arr);
    }
    public static int[]countingSort(int []arr){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);
        }
        int []count=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<arr.length;i++){
            while(count[i] > 0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
        return arr;
    }
    public static void bubbleSort1(){
        int []arr={3,6,2,1,8,5,7,4,3,1};
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j] < arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
    }
    public static void insertionSort1(){
        int []arr={3,6,2,1,8,5,7,4,3,1};
        for(int i=1;i<arr.length-1;i++){
            int cur=arr[i];
            int prev=i-1;
            while(prev >= 0 && arr[prev] < cur ){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=cur;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
    }
    public static void SelectionSort1(){
        int []arr={3,6,2,1,8,5,7,4,3,1};
        for(int i=0;i<arr.length;i++){
            int minpos=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minpos] < arr[j]){
                    minpos=j;
                }
            }
            int temp=arr[minpos];
            arr[minpos]=arr[i];
            arr[i]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
    }
    public static void countinSort1(){
        int []arr={3,4,5,2,1,3,6,9,8,7};
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);
        }
        int []count=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=count.length-1;i>=0;i--){
            while(count[i] > 0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
    }
}
