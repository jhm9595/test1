package leetcode;

public class SortAndSearchTwoSum {
	public int[] twoSum(int[] nums, int target) {
        
        int[] sortedArr = _mergeSort(nums);
        
        int[] twoValueArr = _searchTwoValue(sortedArr, target);
        
        int i = -1;
        int j = -1;
        boolean setI = false; // array can have same value for example {3,3}
        for(int k = 0; k < nums.length; k++){
            if(!setI && nums[k] == twoValueArr[0]){
                i = k;
                setI = true;
            }else if(nums[k] == twoValueArr[1]){
                j = k;
            }
            if(i != -1 && j != -1){
                break;
            }
        }
        
        return new int[]{i, j};
    }
    
    private int[] _searchTwoValue(int[] sortedArr, int target){
        
        int r = sortedArr.length - 1;
        
        for(int i = 0 ; i < sortedArr.length; i++){
            while(i < r){
                if(sortedArr[i] + sortedArr[r] > target){
                    r--;
                }else{
                    break;
                }
            }
            if(sortedArr[i] + sortedArr[r] == target){
                return new int[]{sortedArr[i], sortedArr[r]};
            }
        }
        return null;
    }
    
    private int[] _mergeSort(int[] nums){
        
        if(nums.length <= 1){
            return nums;
        }
        
        int len = nums.length;
        int mid = len / 2;
        int[] l = new int[mid];
        int[] r = new int[len - mid];
        
        for(int i = 0; i < len; i++){
            if(i < mid){
                l[i] = nums[i];
            }else{
                r[i-mid] = nums[i];
            }
        }
        
        return _conquer(_mergeSort(l), _mergeSort(r));
    }
    
    private int[] _conquer(int[] l, int[] r){
        int[] result = new int[l.length + r.length];
        
        int lIdx = 0;
        int rIdx = 0;
        int resultIdx = 0;
        while(lIdx < l.length && rIdx < r.length){
            if(l[lIdx] < r[rIdx]){
                result[resultIdx++] = l[lIdx++];
            }else{
                result[resultIdx++] = r[rIdx++];
            }
        }
        
        while(lIdx < l.length){
            result[resultIdx++] = l[lIdx++];
        }
        
        while(rIdx < r.length){
            result[resultIdx++] = r[rIdx++];
        }
        return result;
    }
}
