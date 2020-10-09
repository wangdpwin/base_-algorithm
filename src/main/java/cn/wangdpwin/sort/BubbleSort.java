package cn.wangdpwin.sort;

import static cn.wangdpwin.sort.SortUtil.swap;

import com.alibaba.fastjson.JSON;

/**
 * @Author: wangdongpeng
 * @Date: 2020-07-20 17:04
 * @Description 冒泡排序
 * @Remark  时间复杂度 最坏n方 最好n  平均n方
 *          空间复杂度 1
 *          稳定性    稳定
 * @Version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = Check.randomInt(10);
        System.out.println(JSON.toJSONString(nums));
        sort(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    /**
     * 两个相邻元素比较大小，前比后大的话就交互位置，经过一次循环最大元素到最后一位
     * n-1次循环后，完成排序，两两比较大小，相同值未知不会变化，稳定
     * @param nums
     */
    public static void sort(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            bubbleMax(nums,i);
        }
    }

    private static void bubbleMax(int[] nums,int i) {
        for(int j=0;j<nums.length-i-1;j++) {
            if(nums[j]>nums[j+1]) {
                swap(nums,j,j+1);
            }
        }
    }

    /**
     * TODO
     * 优化，最好时间复杂度为 n
     */
    public static void sort2() {

    }

}
