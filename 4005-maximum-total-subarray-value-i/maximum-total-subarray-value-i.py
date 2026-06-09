class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        gmin= gmax= nums[0]
        for n in nums:
            gmin= min(gmin,n)
            gmax= max(gmax, n)
        
        return k * (gmax-gmin)
        