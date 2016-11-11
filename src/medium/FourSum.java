package medium;

/**
 * Created by kekai on 16/11/7.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> four = new ArrayList<>();
        if(nums == null || len < 4) {
            return four;
        }
        Arrays.sort(nums);
        int max = nums[len - 1];
        for (int i = 0; i < len - 3; i++) {
            int z = nums[i];
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if(z + 3 * max < target) {
                continue;
            } else if(4 * z > target) {
                break;
            } else if (4 * z == target) {
                if(i + 3 < len && nums[i + 3] == z){
                    four.add(Arrays.asList(z,z,z,z));
                    break;
                }
            }

            int newTarget = target - z;
            four.addAll(threeSumTarget(nums, i+1, len, z, newTarget));
        }
        return four;
    }

    public static List<List<Integer>> threeSumTarget(int[]nums, int start, int end, int z, int target) {
        int max = nums[end-1];
        List<List<Integer>> four = new ArrayList<>();

        for(int i = start; i < end-2; i++) {
            int newz = nums[i];
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            if(newz + 2 * max < target) {
                continue;
            }else if(3 * newz > target) {
                break;
            }else if (3 * newz == target) {
                if(i + 2 < end && nums[i+2] == nums[i]) {
                    four.add(Arrays.asList(z,newz,newz,newz));
                    break;
                }
            }
            int newTarget = target - newz;
            four.addAll(towSumTarget(nums, i+1, end, z, newz, newTarget));
        }
        return four;
    }

    public static List<List<Integer>> towSumTarget(int[]nums, int start, int end, int z1, int z2, int target) {
        int lo = start;
        int hi = end-1;
        List<List<Integer>> four = new ArrayList<>();

        while(lo < hi) {
            if(nums[lo] + nums[hi] == target) {
                four.add(Arrays.asList(z1,z2,nums[lo],nums[hi]));
                while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                lo++;
                hi--;
            }else if (nums[lo] + nums[hi] < target) {
                lo++;
            }else if (nums[lo] + nums[hi] > target) {
                hi--;
            }
        }
        return four;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,0,0};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }

}
