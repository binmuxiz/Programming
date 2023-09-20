var arr = [Int](repeating: 0, count: 11)
arr[1] = 1
arr[2] = 2
arr[3] = 4

for _ in 1...Int(readLine()!)! {
    let n = Int(readLine()!)!
    if n > 3 {
        for i in 4...n {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3]
        }
    }
    print(arr[n])
}
