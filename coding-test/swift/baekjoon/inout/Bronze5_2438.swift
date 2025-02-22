let num = Int(readLine()!)!
var str = ""

for i in 1...num {
    for _ in 0..<i {
        str += "*"
    }
    str += "\n"
}
print(str)