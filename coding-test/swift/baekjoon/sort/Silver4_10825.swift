// 국영수

let n = Int(readLine()!)!
var arr : [(String, Int, Int, Int)] = []
for _ in 0..<n {
    let element = readLine()!.split(separator: " ")
    arr.append((String(element[0]), Int(element[1])!, Int(element[2])!, Int(element[3])!))
}

arr.sort { (a,b) in
    if a.1 == b.1 {
        if a.2 == b.2 {
            if a.3 == b.3 {
                return a.0 < b.0
            }
            return a.3 > b.3
        }
        return a.2 < b.2
    }
    return a.1 > b.1
}

var output = ""
for i in arr {
    output += "\(i.0)\n"
}
print(output)