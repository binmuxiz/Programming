for i in 1...Int(readLine()!)! {
    let sum = readLine()!.split(separator: " ").map{Int($0)!}.reduce(0,+)
    print("Case #\(i): \(sum)")
}


// let input = Int((readLine() ?? "")) ?? 0

// for i in 1...input {
//   let input = (readLine() ?? "").split(separator: " ").map { Int(String($0)) ?? 0 }
//   print("Case #\(i): \(input[0] + input[1])")
// }