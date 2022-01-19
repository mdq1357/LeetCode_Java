public class leftOrRightBound_704_34 {
    public static void main(String[] args) {
        int[] a = {1,2,2,4,5};
        System.out.println(left_bound(a,2));
        System.out.println(right_bound(a,2));

        System.out.println(left_bound2(a,2));
        System.out.println(right_bound2(a,2));
    }
    /*
    左闭右闭
     */

    //二分查找
    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/binary-search
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }

    //寻找左边界
    public static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    //寻找右边界
    public static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩左侧边界
                left = mid + 1;
            }
        }
        // 检查越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    /*
    左闭右开
     */

    //寻找左边界
    public static int left_bound2(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        // target 比所有数都大
        if (left == nums.length||nums[left]!=target) return -1;
        return left;
    }

    //寻找右边界
    public static int right_bound2(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
//        return left - 1; // 注意
        if (left == 0||nums[left-1]!=target) return -1;
        return left-1;
    }
}
