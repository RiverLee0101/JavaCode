package algorithm.search;

/**
 * 优点：比较次数少，查找速度快，平均性能好
 * 缺点：要求待查表为有序表，且插入删除困难
 * 使用场景：不经常变动而查找频繁的有序列表
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 8, 10, 15};
        int key = 10;
        System.out.println("普通二分查找：key " + key + " 在第 " + commonBinarySearch(nums, key) + " 位");
        System.out.println("递归二分查找：key " + key + " 在第 " + recursionBinarySearch(nums, key, 0, nums.length - 1) + " 位");
    }

    /**
     * 不使用递归的二分查找
     *
     * @param nums
     * @param key
     * @return
     */
    public static int commonBinarySearch(int[] nums, int key) {
        int low = 0; // 定义首位
        int high = nums.length - 1; // 定义末尾
        int mid; // 定义中位

        if (key < nums[low] || key > nums[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            mid = (high + low) / 2; // 折半
            if (key < nums[mid]) {
                high = mid - 1;
            } else if (key > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 使用递归的二分查找
     *
     * @param nums
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int recursionBinarySearch(int[] nums, int key, int low, int high) {

        if (key < nums[low] || key > nums[high] || low > high) {
            return -1;
        }

        int mid = (high + low) / 2;
        if (nums[mid] > key) {
            // 中间数比关键字大 说明关键字在左边
            return recursionBinarySearch(nums, key, low, mid - 1);
        } else if (nums[mid] < key) {
            // 中间数比关键字小 说明关键字在右边
            return recursionBinarySearch(nums, key, mid + 1, high);
        } else {
            return mid;
        }
    }

}
