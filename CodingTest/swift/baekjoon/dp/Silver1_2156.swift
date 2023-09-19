// 포도주 시식
let n = Int(readLine()!)!
var arr = [Int](repeating: 0, count: n+1)
var dp = [Int](repeating: 0, count: n+1)

for i in 1...n {
    arr[i] = Int(readLine()!)!

    if i == 1 {
        dp[1] = arr[1]
    }
    else if i == 2 {
        dp[2] = arr[1] + arr[2]
    }
    else {
        dp[i] = max(arr[i] + arr[i-1] + dp[i-3], arr[i] + dp[i-2])
        dp[i] = max(dp[i], dp[i-1])
    }
}
print(dp[n])

