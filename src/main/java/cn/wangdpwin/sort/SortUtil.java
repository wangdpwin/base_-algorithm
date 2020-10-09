package cn.wangdpwin.sort;

/**
 * @Author: wangdongpeng
 * @Date: 2020-07-20 17:47
 * @Description
 * @Version 1.0
 */
public class SortUtil {
    public static void swap(int[] nums, int k, int minPos) {
        int min = nums[k];
        nums[k] = nums[minPos];
        nums[minPos] = min;
    }
}
