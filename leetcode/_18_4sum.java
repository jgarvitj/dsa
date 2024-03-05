class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        int kSum = 4;
        int startIndex = 0;
        return findKSum(nums, target, kSum, startIndex);
    }

    private List<List<Integer>> findKSum(int[] nums, long target, int kSum, int startIndex) {
        
        
        List<List<Integer>> results = new ArrayList<>();
        for(int i = startIndex; i <= nums.length - kSum; i++) {
            long newTarget = target - nums[i];
            long avgTarget = newTarget / (kSum - 1);
            if(avgTarget < nums[i+1] || avgTarget > nums[nums.length - 1]) {
                continue;
            }

            if(kSum == 2) {
                return find2Sum(nums, target, i);
            }

            List<List<Integer>> subResults = findKSum(nums, newTarget, kSum-1, i+1);

            for(List<Integer> result : subResults) {
                result.add(0, nums[i]);
                results.add(result);
            }

            while(i < nums.length - kSum && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return results;
    }

    private List<List<Integer>> find2Sum(int[] nums, long target, int startIndex) {
        int p0 = startIndex;
        int p1 = nums.length - 1;

        List<List<Integer>> results = new ArrayList<>();
        while(p0 < p1) {

            if(target == nums[p0] + nums[p1]) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[p0]);
                result.add(nums[p1]);
                results.add(result);

                while(p0 < p1 && nums[p0 + 1] == nums[p0]) {
                    p0++;
                } 
                while(p0 < p1 && nums[p1-1] == nums[p1]) {
                    p1--;
                }
                p0++;
            } else if( target < nums[p0] + nums[p1]) {
                p1--;
            } else {
                p0++;
            }
        }
        return results;
    } 
}
