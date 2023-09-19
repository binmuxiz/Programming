let input = readLine()!.split(separator: " ").map{Int($0)!}
let arr = [31,28,31,30,31,30,31,31,30,31,30,31]
let arr2 = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
var daySum = 0

for i in 1..<input[0] {
    daySum += arr[i-1]
}
daySum += input[1]
print("\(arr2[daySum % 7])")