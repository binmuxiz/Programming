let n = Int(readLine()!)!
var dp = [Int](repeating: 1, count: n)

if n > 2 {
    for i in 2..<n {
        dp[i] = dp[i-1] + dp[i-2]
    }
}
print(dp[n-1])