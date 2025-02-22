// 카드

let n = Int(readLine()!)!
var arr = [Int: Int]()
for _ in 0..<n {
    let key = Int(readLine()!)!
    arr[key] = arr[key] == nil ? 1 : arr[key]! + 1
}

let sortedArr = arr.sorted { (a,b) in
    if a.value == b.value {
        return a.key < b.key
    }
    return a.value > b.value
}
print(sortedArr[0].key)