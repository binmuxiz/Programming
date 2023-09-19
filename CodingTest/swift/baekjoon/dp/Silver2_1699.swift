// 제곱수의 합
let n = Int(readLine()!)!
var dp = [Int](repeating: 0, count: n+1)
dp[1] = 1

if n > 1 {
    for i in 2...n {
        dp[i] = i
        var k = 1
        while k*k <= i {
            dp[i] = min(dp[i-(k*k)] + 1, dp[i])
            k = k+1
        }    
    }
}
print(dp[n])