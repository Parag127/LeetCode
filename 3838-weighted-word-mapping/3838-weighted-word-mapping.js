/**
 * @param {string[]} words
 * @param {number[]} weights
 * @return {string}
 */
var mapWordWeights = function(words, weights) {
    let ans = "";

    for (let word of words) {
        let sum = 0;

        for (let ch of word) {
            sum += weights[ch.charCodeAt(0) - 97]
        }

        ans += String.fromCharCode(122 - (sum % 26))
    }

    return ans;
};