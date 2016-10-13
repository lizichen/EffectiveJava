package BitManipulation;

/**
 * Created by lizichen1 on 10/12/16.
 *
 * 136. Single Number
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Tag: Bit Manipulation
 */
public class SingleNumber_136 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1,2,4,3,5};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(i == 0)
                nums[0] = nums[0] ^ 0; //Trick!
            else
                nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
}
