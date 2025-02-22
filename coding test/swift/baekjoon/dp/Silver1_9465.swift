for _ in 1...Int(readLine()!)! {
    let n = Int(readLine()!)!
    var score: [[Int]] = Array(repeating: Array(repeating: 0, count: n+1), count: 2)
    
    for i in 0...1 {
        let line = readLine()!.split(separator: " ").map{Int($0)!}
        for j in 1...n {
            score[i][j] = line[j-1]
        }
    }
    
    if n > 1 {
        for i in 2...n {
            score[0][i] = max(score[1][i-1], score[1][i-2]) + score[0][i]
            score[1][i] = max(score[0][i-1], score[0][i-2]) + score[1][i]
        }
    }
    print(max(score[0][n], score[1][n]))
}