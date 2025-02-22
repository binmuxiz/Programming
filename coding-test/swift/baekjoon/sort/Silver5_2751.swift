// 수 정렬하기 2

let n = Int(readLine()!)!
var arr : [Int] = []
for _ in 0..<n {
    arr.append(Int(readLine()!)!)
}
var output = ""
for e in arr.sorted() {
    output.write("\(e)\n")
}
print(output)
