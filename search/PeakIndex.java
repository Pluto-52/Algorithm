package search;

public class PeakIndex {
    public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+right>>1;
            if(arr[mid-1]<arr[mid]&&arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid-1]<arr[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        PeakIndex pi=new PeakIndex();
        int[] arr={1,3,5,7,9,11,9,7,5,3,1};
        System.out.println(pi.peakIndexInMountainArray(arr));
    }
}
