import java.util.Arrays;

public class DivideAndConquer {
    public static void main(String[] args) {
        int []arr2={9,8,7,6,5,4,3,2,1};
        printArray(arr2);
        mergeSort(arr2,0,arr2.length-1);
        printArray(arr2);
        int []arr1={9,8,7,6,5,4,3,2,1};
        printArray(arr1);
        quickSort(arr1,0,arr1.length-1);
        printArray(arr1);
        int []arr={4,5,6,7,0,1,2};
        System.out.println(rotatedSearch(arr,0,arr.length,0));
        String []arr3={"sun","earth","mars","mercury"};
        String []arr4=mergeSort1(arr3,0,arr3.length-1);
        for(int i=0;i<arr4.length;i++){
            System.out.print(arr4[i]+" ");
        }
        int []arr5={2,3,3,1,3,3};
        System.out.println(majorityElement(arr5));
        
    }
    public static void printArray(int []arr){
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int []arr,int start,int end){
        if(start >= end){
            return;
        }
        int mid=start+(end-start)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
        
    }
    public static void merge(int []arr,int start,int mid,int end){
        int []temp=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=end){
            if(arr[i] < arr[j]){
                temp[k]=arr[i];
                i++;k++;
            }else{
                temp[k]=arr[j];
                j++;k++;
            }
        }
        while(i<=mid){
            temp[k]=arr[i];
            k++;i++;
        }
        while(j<=end){
            temp[k]=arr[j];
            j++;k++;
        }
        for(k=0,i=start;k<temp.length;i++,k++){
            arr[i]=temp[k];
        }
    }
    public static void quickSort(int []arr,int start,int end){
        if(start >= end){
            return;
        } 
        int pindex=partition(arr,start,end);
        quickSort(arr,start,pindex-1);
        quickSort(arr,pindex+1,end);
    }
    public static int partition(int []arr,int start,int end){
        int pivot=arr[end];
        int i=start-1;
        for(int j=start;j<=end;j++){
            if(arr[j] < pivot){
                i++;
                int temp=arr[j];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[end];
        arr[end]=arr[i];
        arr[i]=temp;
        return i;
    }
    public static int rotatedSearch(int []arr,int start,int end,int target){
        int mid=start+(end-start)/2;
        if(start > end){
            return -1;
        }
        if(arr[mid] == target){
            return mid;
        }
        if(arr[start] <= arr[mid]){
            if(arr[start] <= target && target <=arr[mid] ){
                return rotatedSearch(arr,start,mid-1,target);
            }else{
                return rotatedSearch(arr,mid+1,end,target);
            }
        }else{
            if(arr[mid] <= target && target <= arr[end]){
                return rotatedSearch(arr,mid+1,end,target);
            }else{
                return rotatedSearch(arr,start,mid-1,target);
            }
        }
    }
    public static String[] mergeSort1(String []arr,int start,int end){
        if(start == end){
            String []a={arr[start]};
            return a;
        }
        int mid=start+(end-start)/2;
        String []arr1=mergeSort1(arr,start,mid);
        String []arr2=mergeSort1(arr,mid+1,end);
        String []arr3=merge(arr1,arr2);
        return arr3;
    }
    public static String[] merge(String []arr1,String []arr2){
        int m=arr1.length;
        int n=arr2.length;
        String []arr3= new String[m+n];
        int index=0;
        int i=0;
        int j=0;
        while(i < m && j < n){
            if(isAlphabaticalOrder(arr1[i],arr2[j])){
                arr3[index]=arr1[i];
                i++;
                index++;
            }else{
                arr3[index] = arr2[j];
                j++;
                index++;
            }
        }
        while(i < m){
            arr3[index]=arr1[i];
            i++;
            index++;
        }
        while(j < n){
            arr3[index]=arr2[j];
            j++;
            index++;
        }
        return arr3;
    }
    public static boolean isAlphabaticalOrder(String arr1,String arr2){
        if(arr1.compareTo(arr2) < 0){
            return true;
        }
        return false;
    }
    public static int majorityElement(int []arr){
        Arrays.sort(arr);
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);
        }
        int []count=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        largest=Integer.MIN_VALUE;
        for(int i=0;i<count.length;i++){
            largest=Math.max(largest,count[i]);
        }
        int index=-1;
        for(int i=0;i<count.length;i++){
            if(largest == count[i]){
                index=i;
            }
        }
        if(largest > arr.length/2){
            return index;
        }else{
            return -1;
        }
    }
}
