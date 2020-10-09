package cn.wangdpwin.sort;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;

/**
 * @Author: wangdongpeng
 * @Date: 2020-07-16 19:17
 * @Description 选择排序算法
 * @Remark 时间复杂度 最好n方 最坏n方 平均n方
 *         空间复杂度 1
 *         稳定性    不稳  相同数值会发生位置变化
 * @Version 1.0
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] nums = {5,3,8,4,2,1,9,6};
//        int[] nums = randomInt();
        int[] nums2 = nums.clone();
        //before
        System.out.println(JSON.toJSONString(nums));
        sort2(nums);
        //after
        String mySort = JSON.toJSONString(nums);
        System.out.println();


        Arrays.sort(nums2);
        String jdkSort = JSON.toJSONString(nums2);
        System.out.println(mySort.equals(jdkSort));

//        compareInt(nums,nums2);


    }

    private static void compareInt(int[] nums, int[] nums2) {
        for(int i=0;i<1000;i++) {
            if(nums[i]!=nums2[i]) {
                System.out.println("mySort:   " + nums[i]);
                System.out.println("jdkSort:   " + nums2[i]);
            }
        }
    }

    /**
     * 设定最小值下标为minPos，假设第一位是最小值min 即minPos=0，和后面的元素对比，如果第N位比min小则 minPos=N，遍历到数组尾部等到 最小值 minN
     * 第一轮已经找到第一个最小值，互换设定下标元素数据和查找到的下标位置最小值，即互换 min minN，此时可以考虑使用位运算优化数据交换操作
     * 开始下一轮，此时假设 第二位是最小值min 即minPos=1，以此类推到数组尾部，数据完成排序
     * @param nums
     */
    public static void sort(int[] nums) {
        for(int k=0;k<nums.length-1;k++) {
            int minPos = k;
            for(int i=k+1;i<nums.length;i++) {
                if(nums[i]<nums[minPos]) {
                    minPos = i;
                }
            }
//            System.out.println("最小值是 " + nums[minPos]);
            swap(nums,k,minPos);
        }
    }

    private static void swap(int[] nums, int k, int minPos) {
        int min = nums[k];
        nums[k] = nums[minPos];
        nums[minPos] = min;
    }

    /**
     * 优化方案 最小值最前面 最大值最后面
     * 找到最小值的同时找到最大值，交互新最小值 新最大值
     * 假设 0下标 length-1下标元素 分别为最小值 最大值
     * 分别迭代最大值最小值位置
     * n/2次完成排序
     */
    //Fixme:bug todo fix
    public static void sort2(int[] nums) {
        for(int i=0;i<nums.length/2+1;i++) {
            int minPos = i;
            int maxPos = nums.length-i-1;
            if(minPos>maxPos) {
                break;
            }
            System.out.println("交换前    " + "minPos：" + minPos + "   maxPos：" + maxPos);
            for(int j=i+1;j<nums.length-i;j++) {
                if(nums[minPos]>nums[j]) {
                    minPos = j;
                }
                if(nums[maxPos]<nums[nums.length-1-j]) {
                    maxPos = nums.length-1-j;
                }
            }

            if(i==maxPos || nums.length-i-1==minPos) {
                System.out.println("bug =======");
                if(i!=minPos) {
                    swap(nums,i,minPos);
                }
            }else {
                if(i!=minPos) {
                    swap(nums,i,minPos);
                }
                if(maxPos!=nums.length-i-1) {
                    swap(nums,nums.length-i-1,maxPos);
                }
            }

            System.out.println("交换后    " + "minPos：" + minPos + "   maxPos：" + maxPos);
            System.out.println("第 " + i + " 次： " + JSON.toJSONString(nums));
            System.out.println("\n");
        }

    }

    /**
     * 优化
     * 一次拿出两个元素和假设的最小值元素对比
     * @param nums
     */
    private static void sort3(int[] nums) {

    }

}
