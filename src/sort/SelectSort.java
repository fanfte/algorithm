package sort;

/**
 * Created by tianen on 2019/4/16
 *
 * @author fanfte
 * @date 2019/4/16
 **/
public class SelectSort {

    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int minIndex = -1;
        for(int i = 0 ;i < array.length; i ++) {
            int j = i;
            int min = Integer.MAX_VALUE;
            for (; j < array.length; j ++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {9, 6, 7, 3, 1, 2, 4, 5, 11};
        new SelectSort().sort(array);
        SortUtil.printArr(array);
    }
}
