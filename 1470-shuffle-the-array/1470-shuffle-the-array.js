/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number[]}
 */
var shuffle = function(nums, n) {
let arr = [];

for (i = 0; i < n; i++) {
    arr[2 * i] = nums[i];
    arr[2 * i + 1] = nums[i + n];
}

return arr
};