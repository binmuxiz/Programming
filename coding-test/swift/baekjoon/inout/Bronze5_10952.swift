while true {
    let sum = readLine()!.split(separator: " ").map { Int($0)! }.reduce(0, +)
    if sum == 0 {
        break
    }
    print(sum)
}