let num = Int(readLine()!)!
for i in 0..<num {
    var str = ""
    for _ in 0..<num-i {
        str += "*"
    }
    print(str)
}