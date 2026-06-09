class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:

      #  [1,2,3,4,4,3,2,1]
      #   1,4,2,3,4,2,4,1
        result = []
        for i in range(n):
            #append i th num
            result.append(nums[i])
            #append i+nth num
            result.append(nums[i+n])
        return result


    