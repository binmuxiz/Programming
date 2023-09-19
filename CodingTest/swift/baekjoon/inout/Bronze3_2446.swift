if let input = readLine() {
    let n = Int(input) ?? 0 
    for i in 0..<n {
        print(String(repeating: " ", count: i), terminator: "")
        print(String(repeating: "*", count: (n*2-1)-(i*2)))
    }
    for i in 1..<n {
        print(String(repeating: " ", count: n-i-1), terminator: "")
        print(String(repeating: "*", count: i*2+1))
    }
}