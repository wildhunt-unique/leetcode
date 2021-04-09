package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dx DingXing
 * @date 2020-02-18
 */
public class FourSum {

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int low = j + 1, high = nums.length - 1;
                int sub = target - nums[i] - nums[j];
                while (low < high) {
                    if (nums[low] + nums[high] < sub) {
                        low++;
                    } else if (nums[low] + nums[high] > sub) {
                        high--;
                    } else {
                        results.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        if ((nums[low] == nums[low + 1]) && nums[high] == nums[high - 1]) {
                            low += 2;
                            high -= 2;
                        } else {
                            low++;
                            high--;
                        }

                    }
                }
            }
        }

        return results.stream().distinct().collect(Collectors.toList());
    }
}
