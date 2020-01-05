package com.codepig.selectsort;

import java.util.Arrays;

public class SelectSort3 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 9, 0, 4, 8, 6, 7, 1, 3};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i<arr.length-1; i++){
            int index = i;
            for (int j = i+1; j<arr.length;j++){
                if (arr[j] < arr[index]){
                    index = j;
                }
            }
            //这里是交换，而不是直接赋值。
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            /**
             * if (i!=index){
             *
             */
        }
    }
}
