class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        candidates.sort()
        result = []
        path = []

        def backtrack(start, remaining):
            if remaining == 0:
                result.append(path.copy())
                return

            for i in range(start, len(candidates)):
                value = candidates[i]

                if value > remaining:
                    break

                path.append(value)
                backtrack(i, remaining - value)
                path.pop()

        backtrack(0, target)
        return result


solution = Solution()
print(solution.combinationSum([2, 3, 6, 7], 7))
print(solution.combinationSum([2, 3, 5], 8))
print(solution.combinationSum([2], 1))