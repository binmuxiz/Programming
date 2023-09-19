for i in 1...Int(readLine()!)! {
    let line = readLine()!.split(separator: " ").map{Int($0)!}
    print("Case #\(i): \(line[0]) + \(line[1]) = \(line[0]+line[1])")
}