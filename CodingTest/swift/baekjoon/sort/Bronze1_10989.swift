// 수 정렬하기 3

// counting sort
var countingArr = [Int](repeating: 0, count: 100001)
let n = Int(readLine()!)!

for _ in 0..<n {
    let i = Int(readLine()!)!
    countingArr[i] += 1
}
var output = ""
for i in 1...10000 {
    output += String(repeating: "\(i)\n", count: countingArr[i])
}
print(output)