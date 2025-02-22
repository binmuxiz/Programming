// 연속합 

let n = Int(readLine()!)!
var dp = readLine()!.split(separator: " ").map{Int($0)!}
for i in 1..<n {
    dp[i] = max(dp[i], dp[i-1] + dp[i])
}
print(dp.max() ?? 0)