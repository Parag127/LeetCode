/**
 * @param {number[]} nums
 * @return {number}
 */
var repeatedNTimes = function(nums) {
    if (nums.length == 1) return nums[0];

    let n = nums.length;
    for (let i = 0; i < nums.length; i++) {
        let count = 0;

        for (j = i + 1; j < nums.length; j++){
            if (nums[i] === nums[j]) count++;
        }

        if (count > 0) return nums[i];

    }
};