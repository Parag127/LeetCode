/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function(nums) {
    let n = nums.length
    let count = new Array(n + 1).fill(0);

    for (i = 0; i < n; i++) {
            count[nums[i]]++;
    }

    let duplicate, missing;

    for (i = 0; i <= n; i++) {
        if (count[i] == 2){
            duplicate = i;
        }

        if (count[i] == 0) {
            missing = i;
        }
    }

    return [duplicate, missing]
    
};