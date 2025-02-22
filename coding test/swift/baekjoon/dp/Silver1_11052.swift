// 카드 구매하기

let n = Int(readLine()!)!
let p = readLine()!.split(separator: " ").map{Int($0)!}
var dp = p

for i in 1..<n {
    for j in 1...i {
        dp[i] = max(dp[i], p[i-j] + dp[j-1])
    }
}
print(dp[n-1])