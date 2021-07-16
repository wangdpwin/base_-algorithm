package cn.wangdpwin.sort;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wangdongpeng
 * @Date: 2020-08-05 17:18
 * @Description 桶排序 时间与空间存在兼容问题
 * @Version 1.0
 */
public class BucketSort {

    public static void main(String[] args) {
        double[] arr = {0.0, 0.12, 0.18, 0.93, 0.45, 0.76, 0.03, 0.55, 0.67, 1.0};
        int[] arr2 ={63,157,189,51,101,47,141,121,157,156,194,117,98,139,67,133,181,13,28,109};
        bucketSort(arr2);
        sort(arr2);
    }

    /**
     *  数组arr   0.0   0.12  0.18  0.93   0.45   0.76  0.03  0.55  0。67  1.0
     *  找到最小值 最大值 根据最小值最大值的差值  就行分段，如  1.0 - 0.0 = 1
     *  假设分成4段，间距为0.25，则分为四段；  [0.0,0.25) [0.25,0.5) [0.5,0.75) [0.75,0.1)
     *  遍历arr，元素分别放入四段中(arraylist或者链表实现，链表存在排序性能问题)
     *  对4段分别排序(插入/递归/快排等)
     *  四段数据合并
     */
    public static void sort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        //找最大值最小值
        for (int i = 1; i < arr.length; i++) {
            if(min>arr[i]) {
                min = arr[i];
            }else if(max<arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("min  " + min);
        System.out.println("max  " + max);

        int count = arr.length/4 + 1;
        //间距
        int len = (max-min)/count;

        List<List<Integer>> buckets = new ArrayList<>(count+1);
        for (int i = 0; i <= count; i++) {
            buckets.add(new LinkedList<>());
        }
        //分桶
        for (int n : arr) {
            int index = (n-min)/len;
            List<Integer> list = buckets.get(index);
            if(list.size()==0) {
                list.add(n);
            }else {
                insertSort(n,list);
            }
        }
        System.out.println(JSON.toJSONString(buckets));
        //分别对桶排序
        for (List<Integer> bucket : buckets) {
            if(CollectionUtils.isNotEmpty(bucket)) {
                Collections.sort(bucket);
            }
        }
        System.out.println(JSON.toJSONString(buckets));
        List<Integer> items = new ArrayList<>(arr.length);
        //对全部桶内数据拼接
        for (List<Integer> bucket : buckets) {
            if(CollectionUtils.isNotEmpty(bucket)) {
                items.addAll(bucket);
            }
        }
        System.out.println(JSON.toJSON(items));
    }

    /**
     * 插入时进行排序
     * @param n
     * @param list
     */
    private static void insertSort(int n, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if(n<list.get(i)) {
                list.add(i,n);
                break;
            }
        }
    }

    public static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }
        System.out.println(bucketArr.toString());
    }
}
