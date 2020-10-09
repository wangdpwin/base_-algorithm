package cn.wangdpwin.sort;

/**
 * @Author: wangdongpeng
 * @Date: 2020-08-05 15:53
 * @Description 基数排序  本质是一种多关键字排序
 *              有低位优先和高位优先两种
 *              对个位数排序 对十位数排序 对百位数排序
 *              稳定
 * @Version 1.0
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {};
        sort(arr);
    }

    /**
     * 1. 求最高位数，位数不够时最高位补0】
     * 2. 对每个位数求余 取余 %10  %100
     * 3. 对余数排序，个 十 百 ````
     * 4. 完成排序，返回新数组对象
     * @param arr
     */
    public static void sort(int[] arr) {


    }

    /**
     * 字符串的基数排序
     * abc  def  ghi
     *
     */

}
