/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let purchase = prices[0];
    let maxProfit = 0;

    for (let i = 0; i < prices.length; i++) {
        if (prices[i] < purchase) purchase = prices[i]
        let profit = prices[i] - purchase;
        maxProfit = Math.max(maxProfit, profit)
    }
    return maxProfit
};