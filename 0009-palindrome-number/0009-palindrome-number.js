/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {

    if (x < 0) {
        return false;
    }

    let s = x.toString();
    let reversed = s.split('').reverse().join("");

    return s === reversed;
};