// 나이순 정렬 

let n = Int(readLine()!)!
var arr : [(Int, Int, String)] = []
for i in 0..<n {
    let element = readLine()!.split(separator: " ")
    arr.append((i, Int(element[0])!, String(element[1])))
}
arr.sort { (a,b) in 
    if a.1 == b.1 {
        return a.0 < b.0
    }
    return a.1 < b.1
}
var output = ""
for i in arr {
    output += "\(i.1) \(i.2)\n"
}
print(output)