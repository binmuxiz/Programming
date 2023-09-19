if let input = readLine() {
    let n = Int(input) ?? 0 
    for i in 1...n {
        print(String(repeating: " ", count: n-i), terminator: "")
        print(String(repeating: "*", count: i))
    }
    for i in 1..<n {
        print(String(repeating: " ", count: i), terminator: "")
        print(String(repeating: "*", count: n-i))
    }
}