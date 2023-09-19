let num = Int(readLine()!)!

for i in 1...num {
    var str = ""
    for _ in 0..<num-i {
        str += " "
    }
    for _ in 1...2*i-1 {
        str += "*"
    }
    print(str)
}