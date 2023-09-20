// 합분해

let arr = readLine()!.split(separator: " ").map{Int($0)!}
let n = arr[0]
let k = arr[1]
var dp : [[Int]] = Array(repeating: Array(repeating: 0, count: k+1), count: n+1)

for i in 1...k {
    dp[0][i] = 1
}

for i in 1...n {
    for j in 1...k {
        for m in 1...j {
            dp[i][j] = (dp[i][j] + dp[i-1][m]) % 1000000000
        }
    }
}
print(dp[n][k])