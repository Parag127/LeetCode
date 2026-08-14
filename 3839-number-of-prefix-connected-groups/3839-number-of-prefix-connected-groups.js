/**
 * @param {string[]} words
 * @param {number} k
 * @return {number}
 */
var prefixConnected = function (words, k) {
    let velorunapi = words;

    let count = {};

    for (let i = 0; i < velorunapi.length; i++) {
        let word = velorunapi[i];

        if (word.length < k) continue;

        let prefix = "";

        for (let j = 0; j < k; j++) {
            prefix += word[j];
        }

        if (count[prefix] == undefined) {
            count[prefix] = 1;
        } else {
            count[prefix]++;
        }
    }

    let ans = 0;

    for (let key in count) {
        if (count[key] >= 2) {
            ans++;
        }
    }

    return ans;
};
