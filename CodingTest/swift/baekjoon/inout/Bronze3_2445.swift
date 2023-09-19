// let num = Int(readLine()!)!

// for i in 1...num*2-1 {
//     var str = ""
//     var tmp = 0
//     if i <= num {
//         tmp = i
//     } else {
//         tmp = num-i%num
//     }
//     for _ in 1...tmp{
//         str += "*"
//     }
//     for _ in 0..<(num-tmp)*2 {
//         str += " "
//     }
//     for _ in 1...tmp{
//         str += "*"
//     }
//     print(str)
// }


if let input = readLine() {
    let n = Int(input) ?? 0
    for i in 1...n {
        print(String(repeating: "*", count: i), terminator: "")
        print(String(repeating: " ", count: (n-i)*2), terminator: "")
        print(String(repeating: "*", count: i))
    }
    for i in 1..<n {
        print(String(repeating: "*", count: num-i), terminator: "")
        print(String(repeating: " ", count: i*2), terminator: "")
        print(String(repeating: "*", count: num-i))
    }
}