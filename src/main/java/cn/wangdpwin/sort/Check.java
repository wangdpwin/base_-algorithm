package cn.wangdpwin.sort;

import java.util.Random;

/**
 * @Author: wangdongpeng
 * @Date: 2020-07-20 17:00
 * @Description 校验排序结果
 * @Version 1.0
 */
public class Check {

    public static int[] randomInt() {
        int[] nums = new int[1000];
        for(int i=0;i<1000;i++){
            Random rand = new Random();
            //取得1-1000的随机正整数
            int n =(rand.nextInt(999)+1);
            nums[i] = n;
        }
        return nums;
    }

    public static int[] randomInt(int length) {
        int[] nums = new int[length];
        for(int i=0;i<length;i++){
            Random rand = new Random();
            //取得1-1000的随机正整数
            int n =(rand.nextInt(99)+1);
            nums[i] = n;
        }
        return nums;
    }

    public static void checkSelector() {
        int[] nums = randomInt();
        SelectSort.sort(nums);
    }

}
