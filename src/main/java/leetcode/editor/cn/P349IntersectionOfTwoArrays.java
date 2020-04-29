//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [9,4] 
//
// 说明: 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//java:两个数组的交集
public class P349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();

            for (Integer i : nums1) {
                set1.add(i);
            }

            for (Integer i : nums2) {
                set2.add(i);
            }

            if (set1.size() < set2.size()) return set_intersection(set1, set2);
            else return set_intersection(set2, set1);

        }

        public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
            int[] output = new int[set1.size()];

            int idx = 0;

            for (Integer integer : set1) {
                if(set2.contains(integer)) {
                    output[idx++] = integer;
                }
            }
            return Arrays.copyOf(output, idx);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}