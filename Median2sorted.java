public class Median2sorted{
    public static double median(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while( i < m && j < n){
            if(nums1[i] < nums2[j] ){
                merge[k++] = nums1[i++];
            }
            else{
                merge[k++] = nums2[j++];
            }
        }
        while(i< m){
            merge[k++] = nums1[i++];
        }
        while(j<n){
            merge[k++] = nums2[j++];
        }
        int total = n+m;
        if(total % 2 == 1){
            return merge[total/2];
        }
        else{
            return (merge[total/2 -1] + merge[total/2])/2.00;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(median(nums1, nums2));
    }
}