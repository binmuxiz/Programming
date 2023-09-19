var cnt = 0
var res = ""
for ch in readLine()! {
    res += String(ch)
    cnt += 1
    if cnt % 10 == 0 {
        res += "\n"
    }
}
print(res)