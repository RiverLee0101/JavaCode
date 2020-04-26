//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针

package leetcode.editor.cn;

//java:合并两个有序数组
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
    }

    /**
     * 比较大的放到尾部，大的所在的那个数组下标减1，直到某一个数组比较完毕
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
//            for (int i = 0; i <= nums2.length; i++) {
//                if (nums2[n-1] >= nums1[m-1]) {
//                    nums1[m+n-1] = nums2[n-1];
//                    n--;
//                } else {
//                    nums1[m+n-1] = nums1[m-1];
//                    m--;
//                }
//            }
            int i = m - 1;
            int j = n - 1;
            int p = m + n - 1;
            while (i >= 0 && j >= 0) {
                nums1[p--] = (nums1[i] < nums2[j]) ? nums2[j--] : nums1[i--];
            }
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}