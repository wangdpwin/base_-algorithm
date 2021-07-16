package cn.wangdpwin.sort;


import static cn.wangdpwin.sort.util.SortUtil.swap;

import cn.wangdpwin.sort.util.Check;
import com.alibaba.fastjson.JSON;
import java.util.Arrays;

/**
 * @Author: wangdongpeng
 * @Date: 2020-07-20 17:04
 * @Description 插入排序
 * @Remark 时间复杂度  n方    最好n(已经有序)
 *         空间复杂度  1
 *         稳定性     稳定
 * @Version 1.0
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = Check.randomInt(10);
        int[] newNums = Arrays.copyOf(nums, nums.length);
        System.out.println(JSON.toJSONString(nums));
        sort(nums);
        System.out.println(JSON.toJSONString(nums));
        Arrays.sort(newNums);
        System.out.println(JSON.toJSONString(newNums));
        System.out.println(JSON.toJSONString(nums).equals(JSON.toJSONString(newNums)));
    }

    /**
     * 假设第一个元素为一个队列A，且该A队列已经有序，
     * 从第二个元素开始，跟A队列中的元素进行比较，如果比A中元素小，就插入到该元素的前面，以此完成一个新元素插入A队列，保证了A的有序，
     * 走到最后一个元素时A完成整个数组的排序
     */
    public static void sort(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            insertMin(nums,i);
        }
    }

    public static void insertMin(int[] nums,int i) {
        for(int j=i+1;j>0;j--) {
            if(nums[j]<nums[j-1]) {
                swap(nums,j,j-1);
            }
        }
    }

}
