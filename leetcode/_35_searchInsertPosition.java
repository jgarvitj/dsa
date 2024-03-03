class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid = (start + end) / 2;
        while(start < mid) {
            
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
            mid = (start + end) / 2;
        }

        if(nums[mid] >= target) {
            return mid;
        } else {
            return mid + 1;
        }
    }
}
