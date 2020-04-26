//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找

package leetcode.editor.cn;

//java:搜索插入位置
public class P35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(solution.searchInsert(nums, target));
    }

    /**
     * 普通二分法解决问题，如果没查找到，那就返回low=high那个索引
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int mid;

            while (low <= high) {
                mid = (high + low) / 2;
                if (target < nums[mid]) {
                    high = mid - 1;
                } else if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            return low;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}