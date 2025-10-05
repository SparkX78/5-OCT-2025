import java.util.HashSet;

public class LongestConsecutive {
    public static int longSequence(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int longest = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int current_num = num;
                int currstreak = 1;
                while(set.contains(current_num+1)){
                    current_num++;
                    currstreak++;
                }
                longest = Math.max(longest, currstreak);
            }
        }
        return longest;
            
    }
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longSequence(nums));
    }
}
