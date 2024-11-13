import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BubbleSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bubblesort {
    public static void Bubblesort(int nums[], int n){
        n = nums.length;
        boolean swapped = true;
        for(int i = 0; i < n - 1; i++){
            swapped = false;
            for (int s = 0; s < n - i - 1; s++){
                if (nums[s] > nums[s + 1]){
                    int tempNum = nums[s];
                    nums[s] = nums [s +1];
                    nums[s+1] = tempNum;
                    swapped = true;
                }
            }
            if(swapped = false){
                break;
            }
        }
    }
}
