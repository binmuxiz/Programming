while let input = readLine() {
    let line = input.split(separator: " ").map { Int($0)! }
    print(line[0] + line[1] )
}