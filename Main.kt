val n = arrayOf(
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
)
fun canplaceInSq(y: Int, x: Int, su: Int): Boolean {
    var y = y
    var x = x
    y /= 3
    x /= 3
    y *= 3
    x *= 3
    for (i in y until y + 3) {
        for (j in x until x + 3) if (n[i][j] == su) return false
    }
    return true
}
fun canplace(y: Int, x: Int, su: Int): Boolean {
    for (i in 0..8) if (n[y][i] == su) return false
    for (i in 0..8) if (n[i][x] == su) return false
    return canplaceInSq(y, x, su)
}

fun Dfs(y: Int, x: Int): Boolean {
    var y = y
    var x = x
    if (x == 9) {
        x = 0
        y++
    }
    if (y == 9) {
        for (i in 0..8) {
            for (j in 0..8) {
                print(n[i][j].toString() + " ")
            }
            println()
        }
        return true
    }
    if (n[y][x] == 0) {
        for (i in 1..9) {
            if (canplace(y, x, i)) {
                n[y][x] = i
                if (Dfs(y, x + 1)) return true
                n[y][x] = 0
            }
        }
    } else return Dfs(y, x + 1)
    return false
}
fun main()
{
    Dfs(0,0)
}