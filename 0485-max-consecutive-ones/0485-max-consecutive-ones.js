/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
    let m = 0;
    let c = 0;

    for (let i = 0; i < nums.length; i++){
        if (nums[i] == 1){
            c++
                if (c > m) {
                    m = c;
                }
        } else {
            c = 0;
        }
    }

    return m;
};