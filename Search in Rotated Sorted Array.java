        /* 
        Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
         O(logn) O1
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
        */
        
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length < 1){
            return -1;
        }
        //find the smallest number index/pivot point - left == right
        //after rotate left must > right otherwise left is min
        int left = 0, right = nums.length - 1;
        /*while(left < right){
            if(nums[left] < nums[right]){
                break;
            }
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        int pivot = left; //=right
        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int realMid = (mid + pivot) % nums.length;
            if(nums[realMid] == target){
                return realMid;
            }
            else if(nums[realMid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;*/
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } 
            //cannot change it to nums[mid] > nums[left] {3, 1} looking for 1
            else if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return - 1;
        
    }
}
