/**
 * @param {number[][]} mat
 * @return {number}
 */
var numSpecial = function (mat) {

    let m = mat.length;
    let n = mat[0].length;
    let rowsOne = new Array(m).fill(0);
    let columnsOne = new Array(n).fill(0);

    let special = 0;

    for (i = 0; i < m; i++) {
        for (j = 0; j < n; j++) {
            if (mat[i][j] == 1) {
                rowsOne[i]++;
                columnsOne[j]++;
            }
        }
    }

    for (i = 0; i < m; i++){
        for (j = 0; j < n; j++) {
            if (mat[i][j] == 1 && rowsOne[i] == 1 && columnsOne[j] == 1) {
                special += 1;
            }
        }
    }

    return special;
};