package leetcode;

/**
 * Created by tianen on 2019/6/12
 *
 * @author fanfte
 * @date 2019/6/12
 **/
public class Test004 {


    /**
     * solution https://blog.csdn.net/hit1110310422/article/details/80865539
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int m = nums1.length;
        int n = nums2.length;

        // 交换数组保证 nums1 length < nums2 length  m <= n
        if (n < m) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tmp = m;
            m = n;
            n = tmp;
        }
        // m + n 为偶数 i + j = m + n -i - j  j = (m + n) / 2 - i
        // m + m 为奇数 把中位数放在左半边 ，左半边的元素会比右半边多一个 i + j = m + n - i - j + 1 ==> j = (m + n + 1) / 2
        // 第二种情况多出来的 1 / 2 = 0 对于第一种情况也不影响，两种情况可以合并成第二种
        int iMin = 0, iMax = m, middle = (m + n + 1) / 2;

        while (iMin <= iMax) {
            int i = iMin + ((iMax - iMin) >> 1);
            int j = middle - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin ++;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax --;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if (((m + n) & 1) == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (j == n) {
                    minRight = nums1[i];
                } else if (i == m) {
                    minRight = nums2[j];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return result;
    }
}
