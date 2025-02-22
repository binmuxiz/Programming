let num = Int(readLine()!)!

for i in 1...num {
    var str = ""
    for _ in 0..<num-i {
        str += " "
    }
    for _ in 0..<i {
        str += "*"
    }
    print(str)
}