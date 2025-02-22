// 파도반 수열

for _ in 1...Int(readLine()!)! {
    let n = Int(readLine()!)!
    var dp = [Int](repeating: 1, count: n + 1)

    if n >= 4 {
        for i in 4...n {
            dp[i] = dp[i-2] + dp[i-3]
        }
    }    
    print(dp[n])
}