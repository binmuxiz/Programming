// 가장 긴 감소하는 부분 수열
let n = Int(readLine()!)!
let arr = readLine()!.split(separator: " ").map{Int($0)!}
var dp = [Int](repeating: 1, count: n)

for i in 1..<n {
    for j in 0..<i {
        if arr[j] > arr[i] {
            dp[i] = max(dp[j]+1, dp[i])
        }
    }
}
print(dp.max() ?? 0)