package cn.wangdpwin.sort;

import static cn.wangdpwin.sort.SortUtil.swap;

import com.alibaba.fastjson.JSON;

/**
 * @Author: wangdongpeng
 * @Date: 2020-07-21 19:18
 * @Description 快速排序
 * @Remark  最好N*logN  最差N方  不稳定   空间：logN
 * @Version 1.0
 */
public class QuickSort {

    /**
     * 本身有序时，时间复杂度N方，优化 随机取一个数和最后一个元素交换，解决 最大元素为轴
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,4,6,9,2,3,5,8,7,10};
//        sort(arr);
        sort(arr,0,arr.length-1);
        System.out.println(JSON.toJSONString(arr));
    }

    public static void sort(int[] arr,int left,int right) {
        System.out.println("left: " + left + "  right: " + right);
        if(left >= right) {
            return;
        }
        //交换一次中轴数据，找到mid中轴位置，分别对中轴 左右 两部分进行排序
        int mid = partition(arr,left,right);
        System.out.println("轴:  " + mid);
        sort(arr,left,mid-1);
        sort(arr,mid+1,right);
    }

    private static int partition(int[] arr,int left,int right) {
        int pivot = arr[right];
        int i = left;
        int j = right-1;
        while (i<=j) {
            //i=j 时，让i往后移一位，确保i和轴索引正确交换元素，如  i==j==8,轴为9时， i++变成9   9和9交换就不会出现轴为最大元素时的bug
            //i<=j 避免多次交换
            while (i<=j && arr[i] <= pivot) {
                i++;
            }
            while (i<=j && arr[j] > pivot) {
                j--;
            }
            if(i<j) {
                swap(arr,i,j);
            }
        }
//        System.out.println(i);
//        System.out.println(j);
//        System.out.println(arr.length-1);
//        System.out.println(JSON.toJSONString(arr));
        //把轴放到 left的右侧  i最后进行了++,所以与i交换即可
        swap(arr,i,right);
        return i;
    }


    /**
     * 测试方法
     * 选取一个元素A作为轴，比A小的放一侧min，比A大的放一侧max，对min 和 max重复进行操作，完成递归排序
     * @param arr
     */
    private static void sort(int[] arr) {
        int pivot = arr[arr.length-1];
        int i = 0;
        int j = arr.length-2;
        while (i<j) {
            //i=j 时，让i往后移一位，确保i和轴索引正确交换元素，如  i==j==8,轴为9时， i++变成9   9和9交换就不会出现轴为最大元素时的bug
            //i<=j 避免多次交换
            while (i<=j && arr[i] <= pivot) {
                i++;
            }
            while (i<j && arr[j] >= pivot) {
                j--;
            }
            if(i<j) {
                swap(arr,i,j);
            }
        }
        System.out.println(i);
        System.out.println(j);
        System.out.println(arr.length-1);
        System.out.println(JSON.toJSONString(arr));
        swap(arr,arr.length-1,i);
    }

}
