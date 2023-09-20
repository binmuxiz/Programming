let n = Int(readLine()!)!
var xyArray : [(Int, Int)] = []
for _ in 0..<n {
    let xy = readLine()!.split(separator: " ").map{Int($0)!}
    xyArray.append((xy[0], xy[1]))
}

xyArray.sort { (a, b) in 
    if a.0 == b.0 {
        return a.1 < b.1
    }
    return a.0 < b.0
}

var output = ""
for i in xyArray {
    output += "\(i.0) \(i.1)\n"
}
print(output)