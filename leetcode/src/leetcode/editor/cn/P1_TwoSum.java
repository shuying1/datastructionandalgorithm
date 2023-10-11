//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 15206 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author Yings
 * @date 2022-08-30 14:27:40
 */
public class P1_TwoSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1_TwoSum().new Solution();
        int[] nums = {2, 7, 11, 15, 7};
        int target = 9;
        int[] res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
      /*      int[] res = new int[2];
            int j = 0;
            for (int i = 0; i < nums.length - 1; i++) {
				for (int k = i+1; k <nums.length ; k++) {
					if (nums[k] == (target - nums[i])) {
						res[j++] = i;
						res[j] = k ;
						break;
					}
				}
            }
            return res;
        }*/

            Map<Integer, Integer> hashMap = new HashMap<>();
            int[] res = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int value = target - nums[i];
                if (hashMap.containsKey(value)) {
                    res[0] = i;
                    res[1] = hashMap.get(value);
                }
                hashMap.put(nums[i], i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
