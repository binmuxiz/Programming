if let input = readLine() {
    let n = Int(input) ?? 0
    for i in 1..<n {
        print(String(repeating: " ", count: n-i), terminator: "*")
        if i != 1 {
            print(String(repeating: " ", count: (i-1)*2-1), terminator: "*")
        }
        print()
    }
    print(String(repeating: "*", count: n*2-1))
}