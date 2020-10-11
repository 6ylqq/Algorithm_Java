## 主要的Java排序算法

### 选择排序
进行**两轮循环**，外循环负责控制排序的序列，内循环负责找最小的数值，找到了最小的数值则和外循环的第一个数值进行交换

### 插入排序
一开始的一个数值是为有序序列，剩下的是无序序列，然后将无序序列的值按照大小，**插入到有序序列中去**

### 冒泡排序
两层循环，**每次都将最大的数冒泡到数组最后**，然后外循环减一，重复至外循环结束即可

### 快速排序
1. 选择基准数
2. 从右找比基准数大的，找到后指针停下
3. 从左找比基准数大的，找到后指针停下
4. 交换两个数
5. 继续循环2-4，直到左右指针相遇
6. 相遇后将相遇位置与基准数位置的数交换
7. 递归排序左边
8. 递归排序右边

### 希尔排序
注意希尔排序不算单纯的随便分组后进行选择排序，其关键在于如何分组——将相隔某个“步长”的记录组成一个子序列，实现**跳跃移动**

### 归并排序