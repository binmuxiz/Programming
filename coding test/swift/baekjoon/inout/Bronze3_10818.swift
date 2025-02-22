let a = Int(readLine()!)!
let nums = readLine()!.split(separator: " ").map{Int($0)!}
var min = nums[0]
var max = nums[0]

for i in nums[1...] {
    if i < min {
        min = i
    }
    if i > max {
        max = i
    }
} 
print("\(min) \(max)")