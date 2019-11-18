package com.codepig.insertsort;

import java.util.Arrays;

public class InsertSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,4,9,1,8,0,3,7,6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i<arr.length; i++){
            for (int j = i-1; j>=0; j--){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

