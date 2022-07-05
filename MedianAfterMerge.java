import java.util.Scanner;

public class MedianAfterMerge {
    public static int median(int[] arr1, int[] arr2 ,int start1, int start2, int end1,  int end2){

        // Write code here
        int mid1= CalcMedian(arr1,start1,end1);
        int mid2= CalcMedian(arr2,start2,end2);

        if (end1 - start1==1){
            return (Integer.max(arr1[start1],arr2[start2]) + Integer.min( arr1[end1],arr2[end2]))/2 ;
        }

        if (mid2==mid1){
            return mid1;
        }

        else if (mid1> mid2){
           return median(arr1,arr2, start1, (end2+start2+1)/2 ,(end1+start1+1)/2, end2 );
        }
        else {
            return median(arr1,arr2, (end1+start1+1)/2, start2, end1, (end2+start2+1)/2);
        }

    }

    public static int CalcMedian(int[] arr, int start, int end){
        int n= end - start +1;

        if (n%2==0){
            return ( (arr[start+ n/2 ] + arr[start+n/2 -1])/2 );
        }
        else return arr[start+n/2];

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr1[] = new int[n];
        int arr2[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr1[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println(median(arr1, arr2, 0,0,n-1,n-1));
    }
}
