N, K = map(int, input().split())
jewels = [int(input()) for _ in range(K)]

l, r = 1, max(jewels)
ans = float('inf')

while l <= r:
    mid = (l + r) // 2
    cnt = sum((jewel + mid - 1) // mid for jewel in jewels)

    if cnt > N:
        l = mid + 1
    else:
        ans = mid
        r = mid - 1

print(ans)
