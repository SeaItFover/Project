package com.codepig.shellsort;

import java.util.Arrays;

/**
 * while
 */
public class ShellSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{10,2,4,0,5,8,7,3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        for (int gap = arr.length/2; gap>=1; gap/=2){
            for (int i = gap; i<arr.length; i++){
                int temp = arr[i];
                int index = i-gap;
                while (index >=0 && arr[index] > temp){
                    arr[index+gap] = arr[index];
                    index = index -gap;
                }
                arr[index+gap] = temp;
            }
        }
    }
}
