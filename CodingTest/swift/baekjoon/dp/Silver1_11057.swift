// 오르막 수 
let n = Int(readLine()!)!
var dp: [[Int]] = Array(repeating: Array(repeating: 1, count: 10), count: n)

for i in 1..<n {
    for j in 1...9 {
        dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10007
    }
}
print(dp[n-1].reduce(0,+) % 10007) 