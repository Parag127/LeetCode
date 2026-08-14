/**
 * @param {number} n
 * @return {number}
 */
var totalMoney = function(n) {
    let ans = 0;
    let z = 0;
    for (let i = 1; i <= n; i++) {
        let x = i

        if (x % 7 == 1 && x > 1) {
            z++;
        }
        if (x > 7) {
            x = (x - 1) % 7 + 1 + z;
        }
        ans += x;
    } 

    return ans;
};