package cn.wangdpwin.sort;

import static cn.wangdpwin.sort.SortUtil.swap;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;

/**
 * @Author: wangdongpeng
 * @Date: 2020-07-20 18:39
 * @Description 希尔排序，插入排序的优化版
 * @Version 1.0
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] nums = Check.randomInt(20);
        int[] newNums = Arrays.copyOf(nums, nums.length);
        sort(nums);
        Arrays.sort(newNums);
    }

    /**
     * TODO 暂时没写好
     * @param nums
     */
    public static void sort(int[] nums) {
        System.out.println(JSON.toJSONString(nums));
        //间隔
        int gap = 4;
        for(int i=4;i<nums.length-1;i++) {
            for(int j=i+1;j>0;j--) {
                if(nums[j]<nums[j-1]) {
                    swap(nums,j,j-1);
                }
            }
        }
        System.out.println(JSON.toJSONString(nums));
    }

}
