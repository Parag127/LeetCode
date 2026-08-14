/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let i = 0;
    let j = nums.length - 1;

    while (i <= j){
        if (nums[i] == target)return i; 
        else if (nums[j] == target) return j;
        i++;
        j--;
    }

    return -1;
    
};