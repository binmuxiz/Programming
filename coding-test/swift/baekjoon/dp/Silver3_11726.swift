// 2 * n 타일링

let n = Int(readLine()!)!
var arr = [Int](repeating: 1, count: n+1)

print(f(n))
func f(_ n: Int) -> Int {
    if n < 2 {
        return arr[n]
    }
    for i in 2...n {
        arr[i] = (arr[i-1] + arr[i-2]) % 10007
    }
    return arr[n]
}