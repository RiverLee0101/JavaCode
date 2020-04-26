//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找

package leetcode.editor.cn;

//java:两数之和 II - 输入有序数组
public class P167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();
    }


    /**
     * target - 遍历到的那个数，两数之差用二分查找法找出
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length; i++) {
                int val = target - numbers[i];
                int low = i + 1;
                int high = numbers.length - 1;
                int mid;
                while(low <= high) {
                    mid = (high + low)/2;
                    if (val < numbers[mid]) {
                        high = mid - 1;
                    } else if (val > numbers[mid]) {
                        low = mid + 1;
                    } else {
                        return new int[] {i+1, mid+1};
                    }
                }
            }

            throw new IllegalArgumentException("No two sum");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}