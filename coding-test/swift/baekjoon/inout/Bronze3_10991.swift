if let input = readLine() {
    let n = Int(input) ?? 0
    for i in 1...n {
        var str = ""
        for _ in 0..<n-i {
            str += " "
        }
        for j in 1...i*2-1 {
            str += j%2 != 0 ? "*" : " "
        }
        print(str)
    }
}