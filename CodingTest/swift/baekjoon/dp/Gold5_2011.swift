// 암호코드

let arr = readLine()!.map{Int(String($0))!} // String으로 변환해주지 않으면 컴파일에러남.
let mod = 1000000

if arr[0] == 0 {
    print(0)

} else {
    let n = arr.count
    var dp = [Int](repeating: 0, count: n+1)
    dp[0] = 1
    dp[1] = 1

    if n > 1 { 
        for i in 2...n {
            if arr[i-1] != 0 {
                dp[i] = dp[i-1] % mod
            } 

            if arr[i-2] != 0 && arr[i-2]*10 + arr[i-1] < 27 {
                dp[i] = (dp[i] + dp[i-2]) % mod
            }
        }
    }
    print(dp[n] % mod)
}

