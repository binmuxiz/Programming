from typing import List

class Solution:
    # 완전 탐식 O(n^2)   n => 배열의 길이
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        for i in range(n):
          for j in range(i+1, n):
            if nums[i] + nums[j] == target:
              return [i, j]
            

     # 정렬 후 O(nlogn) => left, right를 더해서 target과 비교하며 left/right를 한칸씩 옮긴다. O(n) ==> O(nlogn) 
     # 정렬 된 인덱스를 반환하면 안되므로 다른 방법 생각해야함.
    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        left, right = 0, n-1
        nums.sort()
        while left<right:
           if nums[left] + nums[right] == target:
              return [left, right]
           elif nums[left] + nums[right] < target:
              left += 1
           elif nums[left] + nums[right] > target:
              right -= 1


solution = Solution()
print(solution.twoSum2(nums=[3,2,4], target=6))

