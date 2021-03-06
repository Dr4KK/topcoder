package easy;

/**
 * Created by kekai on 16/11/10.
 */

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.


 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        int before = nums[0];
        int currentIndex = 1;
        for (int i = 1; i < len; i++) {
            if(before != nums[i]) {
                nums[currentIndex] = nums[i];
                currentIndex++;
                before = nums[i];
            }
        }
        return currentIndex;
    }
}
