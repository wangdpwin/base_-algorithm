package cn.wangdpwin.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author: wangdongpeng
 * @Date: 2020-07-21 16:43
 * @Description 归并排序
 * @Remark N*logN  N  稳定
 * @Version 1.0
 */
public class MergeSort {

    public static void main(String[] args) {
        //奇数个
        //int[] nums = {1,4,7,8,3,6,9};
        //偶数个
        int[] nums = {1,4,7,8,3,5,6,9};
        //sort(nums);
        //使用递归完成归并排序
        sortWithRecursion(nums);
    }

    /**
     * 归并排序，讲数组不断拆解，至最小单元后，
     * @param nums
     */
    private static void sortWithRecursion(int[] nums) {
        //数值合法性校验
        sort(nums,0,nums.length-1);
    }

    /**
     * 递归的操作应该是sort方法，而不是merge，merge应该是最后一步对结果进行整合，sort不断更新left right对新的数组单元就行排序
     * @param nums
     * @param left
     * @param right
     */
    private static void sort(int[] nums, int left, int right) {
        //meger(nums,0,4,7);
        if(left==right) {
            return;
        }
        int mid = left + (right - left)/2;
        //左排
        sort(nums,left,mid);
        //右排
        sort(nums,mid+1,right);
        //合并
        meger(nums,left,mid+1,right);
    }
    /**
     * 归并方法
     * @param nums 数组
     * @param left 左起点
     * @param right 右起点
     * @param rightBound 右边界
     */
    private static void meger(int[] nums, int left, int right, int rightBound) {
        int mid = right - 1;
        int i = left;
        int j= right;
        int[] arr = new int[rightBound - left + 1];

        for(int k=0;k<arr.length;k++) {
            if(i>mid) {
                System.out.println("左侧小数组超了");
                arr[k] = nums[j++];
                continue;
            }
            if(j>nums.length-1) {
                System.out.println("右侧小数组超了");
                arr[k] = nums[i++];
                continue;
            }
            arr[k] = nums[i]<=nums[j] ? nums[i++] : nums[j++];
        }
        System.out.println(JSON.toJSONString(arr));
    }

//========================  测试方法  =====================================

    /**
     * 一个数组，可以分成两个子数组AB，两个部分分别有序，定义一个新数组arr用来存放结果，比较AB的元素大小，小的放入arr，指针移向小的元素所在数组的下一个元素，以此类推
     * 注意点：当某个数组已经到末尾时，停止上述操作改为对另一个数组剩余元素挨着放入arr中
     * @param nums
     */
    private static void sort(int[] nums) {
        //固定分成两个数组，进行测试
        //int[] merge = merge(nums);
        int[] merge = mergeProd(nums);
        System.out.println(JSON.toJSONString(merge));
    }



    /**
     * 三个指针，i指向A数组元素起始位置，j指向B数组元素起始位置，k指向arr数组元素起始位置
     * @param nums
     * @return
     */
    private static int[] merge(int[] nums) {
        //临时变量用于计算数组起点
        int mid = nums.length/2;
        int i=0;
        //数组长度 奇偶数导致第二个数组
        int j= nums.length % 2 == 0 ? mid : mid+1;
        //边界条件，判断数组是否已到结尾
        mid = nums.length % 2 == 0 ? mid : mid+1;
        int[] arr = new int[nums.length];

        for(int k=0;k<nums.length;k++) {
            if(i>=mid) {
                System.out.println("左侧小数组超了");
                arr[k] = nums[j];
                j++;
                continue;
            }
            if(j>nums.length-1) {
                System.out.println("右侧小数组超了");
                arr[k] = nums[i];
                i++;
                continue;
            }
            // <= 保证相等元素位置不变，保证稳定性
            if(nums[i]<=nums[j]) {
                arr[k] = nums[i];
                i++;
            }else {
                arr[k] = nums[j];
                j++;
            }
        }
        return arr;
    }

    /**
     * 改进版，一天一个装X小技巧，也有使用while循环完成的，感觉那种风格很C++，不习惯，所以没写
     * @param nums
     * @return
     */
    private static int[] mergeProd(int[] nums) {
        int mid = nums.length >> 1;
        int i=0;
        int j= nums.length % 2 == 0 ? mid : mid+1;
        mid = nums.length % 2 == 0 ? mid : mid+1;
        int[] arr = new int[nums.length];

        for(int k=0;k<nums.length;k++) {
            if(i>=mid) {
                System.out.println("左侧小数组超了");
                arr[k] = nums[j++];
                continue;
            }
            if(j>nums.length-1) {
                System.out.println("右侧小数组超了");
                arr[k] = nums[i++];
                continue;
            }
            arr[k] = nums[i]<=nums[j] ? nums[i++] : nums[j++];
        }
        return arr;
    }


}
