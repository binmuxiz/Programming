// 8ms
let caseNum = Int(readLine()!)!

for _ in 0..<caseNum {
    let line = readLine()!.split(separator: " ").map{Int($0)!}
    print(line[0] + line[1])
}

