package medium;

/**
 * Created by kekai on 16/11/7.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p>
 * [43,75,-90,47,-49,72,17,-31,-68,-22,-21,-30,65,88,-75,23,97,-61,53,87,
 * -3,33,20,51,-79,43,80,-9,34,-89,-7,93,43,55,-94,29,-32,-49,25,72,-6,35,
 * 53,63,6,-62,-96,-83,-73,66,-11,96,-90,-27,78,-51,79,35,-63,85,-82,-15,100,
 * -82,1,-4,-41,-21,11,12,12,72,-82,-22,37,47,-18,61,60,55,22,-6,26,-60,-42,
 * -92,68,45,-1,-26,5,-56,-1,73,92,-55,-20,-43,-56,-15,7,52,35,-90,63,41,-55,
 * -58,46,-84,-92,17,-66,-23,96,-19,-44,77,67,-47,-48,99,51,-25,19,0,-13,-88,
 * -10,-67,14,7,89,-69,-83,86,-70,-66,-38,-50,66,0,-67,-91,-65,83,42,70,-6,52,
 * -21,-86,-87,-44,8,49,-76,86,-3,87,-32,81,-58,37,-55,19,-26,66,-89,-70,-69,
 * 37,0,19,-65,38,7,3,1,-96,96,-65,-52,66,5,-3,-87,-16,-96,57,-74,91,46,-79,0,
 * -69,55,49,-96,80,83,73,56,22,58,-44,-40,-45,95,99,-97,-22,-33,-92,-51,62,20,70,90]
 * 284
 */
public class ThreeSumCloset {

    /* public int threeSumClosest(int[] nums, int target) {
         int len = nums.length;
         int maxDistance = Integer.MAX_VALUE;
         int currentSum = 0;
         for (int i = 0; i < len-2; i++) {
             for (int j = i + 1; j < len - 1 ; j++) {
                 for(int k = j + 1; k < len; k++) {
                     int sum = nums[i] + nums[j] + nums[k];
                     int distance = Math.abs(sum - target);
                     if(maxDistance > distance) {
                         maxDistance = distance;
                         currentSum = sum;
                     }
                 }
             }
         }
         return currentSum;
     }*/
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int sum = target - nums[i];
                int lo = i + 1;
                int hi = nums.length - 1;


                while (lo < hi) {
                    int current = nums[i] + nums[lo] + nums[hi];
                    if (nums[lo] + nums[hi] == sum) {
                        return target;
                    } else if (nums[lo] + nums[hi] < sum) {
                        results.add(current);
                        lo++;
                    } else {
                        results.add(current);
                        hi--;
                    }
                }
            }
        }
        int near = Integer.MAX_VALUE;
        int mark = 0;
        for (int i = 0; i < results.size(); i++) {
            int distance = Math.abs(results.get(i) - target);
            if (near > distance) {
                near = distance;
                mark = i;
            }
        }

        return results.get(mark);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
        int target = 82;
        System.out.println(threeSumClosest(nums, target));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> sums = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        sums.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }

        }
        return sums;

    }
}
