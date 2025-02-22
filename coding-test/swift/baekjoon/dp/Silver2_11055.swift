// 가장 큰 증가하는 부분 수열
let n = Int(readLine()!)!
let arr = readLine()!.split(separator: " ").map{Int($0)!}
var dp = arr

for i in 1..<n {
    for j in 0..<i {
        if arr[j] < arr[i] {
            dp[i] = max(dp[j] + arr[i], dp[i])
        }
    }
}
print(dp.max() ?? 0)