// 가장 긴 바이토닉 부분 수열
let n = Int(readLine()!)!
let arr = readLine()!.split(separator: " ").map{Int($0)!}
var dp : [[Int]] = Array(repeating: Array(repeating: 1, count: n), count: 2)

// LIS
for i in 1..<n {
    for k in 0..<i {
        if arr[k] < arr[i] {
            dp[0][i] = max(dp[0][i], dp[0][k] + 1)
        }
    }
}
// LDS
for i in stride(from: n-2, to: -1, by: -1) {
    for k in i+1..<n {
        if arr[k] < arr[i] {
            dp[1][i] = max(dp[1][i], dp[1][k] + 1)
        }
    }
}
var res = 0
for i in 0..<n {
    res = max(res, dp[0][i] + dp[1][i])
}
print(res-1)