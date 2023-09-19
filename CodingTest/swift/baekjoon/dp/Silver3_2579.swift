// 계단 오르기

let n = Int(readLine()!)!
var arr = [Int](repeating: 0, count: n+1)
var dp = [Int](repeating: 0, count: n+1)

for i in 1...n {
    arr[i] = Int(readLine()!)!
}

dp[1] = arr[1]
if n > 1 {
    dp[2] = arr[2] + arr[1]
}
if n > 2 {
    for i in 3...n {
        dp[i] = max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i]
    }
}
print(dp[n])