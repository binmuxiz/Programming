let mod = 1000000000
let n = Int(readLine()!)!
var dp: [[Int]] = Array(repeating: Array(repeating: 1, count: 10), count: n)
dp[0][0] = 0

for i in 1..<n {
    dp[i][0] = dp[i-1][1] 
    for j in 1...9 {
        if j == 9 {
            dp[i][j] = dp[i-1][8]
        } else {
            dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod
        }
    }
}
print(dp[n-1].reduce(0,+) % mod)


