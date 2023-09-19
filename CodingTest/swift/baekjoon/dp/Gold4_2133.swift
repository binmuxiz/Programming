// 타일 채우기 (3*N)

let n = Int(readLine()!)!
if n % 2 != 0 {
    print(0)
} else {
    var dp = [Int](repeating: 0, count: n+1)
    dp[2] = 3
    for i in stride(from: 4, to: n+1, by: 2) {
        dp[i] = dp[i-2] * dp[2] + 2
        for k in stride(from: i-4, to: 1, by: -2) { 
            dp[i] = dp[i] + (2 * dp[k])
        }
    }
    print(dp[n])
}
