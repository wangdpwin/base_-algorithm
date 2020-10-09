package cn.wangdpwin.sort;

/**
 * @Author: wangdongpeng
 * @Date: 2020-08-05 15:28
 * @Description 计数排序
 * @Version 1.0  时间 N+K   空间 N+K   不需要比较
 *
 */
public class CountSort {

    /**
     * 特殊情况的排序
     * 量大但是范围小
     * 计算华为员工年龄排序，员工N，年龄范围为 0-80
     * 生成一个数组arr，根据年龄的数值 对应的数组arr的小标处数值+1 表示该数值出现了几次
     * 遍历arr根据元素数值进行减减，减到0时说明该数值已经完成，继续下一个元素的处理
     * 缺点：
     *      不稳定：累加数组    新增一个数组，从下标为1处对arr进行累加计算，arr[1] = arr[0] + arr[1]  arr[2] = arr[1] + arr[2]，定义一个新数组存放结果result，对原数组进行逆序遍历得到数值i，`````TODO
     *      部分值不存在，浪费数组空间：找到最大值man，最小值min，数值减去min放入数组下标，max为数组长度
     */


}
