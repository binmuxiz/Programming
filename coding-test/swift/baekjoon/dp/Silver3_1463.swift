// 1로 만들기

let n = Int(readLine()!)!
var countArr = [Int](repeating: 0, count: n+1)

print(bottomUp(n))

func bottomUp(_ n: Int) -> Int {

    if n == 1 {
        return 0
    }

    for i in 2...n {
        countArr[i] = countArr[i-1] + 1

        if i % 3 == 0 {
            countArr[i] = min(countArr[i/3] + 1, countArr[i])
        }
        
        if i % 2 == 0 {
            countArr[i] = min(countArr[i/2] + 1, countArr[i])
        }
    }
    return countArr[n]
}


print(topDown(Int(readLine()!)!))

func topDown(_ n: Int) -> Int{
    return n < 2 ? 0 : min(topDown(n/2) + n%2, topDown(n/3) + n%3) + 1
}


