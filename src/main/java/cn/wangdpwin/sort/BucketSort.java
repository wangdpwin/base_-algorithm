package cn.wangdpwin.sort;

/**
 * @Author: wangdongpeng
 * @Date: 2020-08-05 17:18
 * @Description 桶排序 时间与空间存在兼容问题
 * @Version 1.0
 */
public class BucketSort {

    public static void main(String[] args) {
        double[] arr = {0.0, 0.12, 0.18, 0.93, 0.45, 0.76, 0.03, 0.55, 0.67, 1.0};
        sort(arr);
    }

    /**
     *  数组arr   0.0   0.12  0.18  0.93   0.45   0.76  0.03  0.55  0。67  1.0
     *  找到最小值 最大值 根据最小值最大值的差值  就行分段，如  1.0 - 0.0 = 1
     *  假设分成4段，间距为0.25，则分为四段；  [0.0,0.25) [0.25,0.5) [0.5,0.75) [0.75,0.1)
     *  遍历arr，元素分别放入四段中(arraylist或者链表实现，链表存在排序性能问题)
     *  对4段分别排序(插入/递归/快排等)
     *  四段数据合并
     */
    public static void sort(double[] arr) {

    }

}
