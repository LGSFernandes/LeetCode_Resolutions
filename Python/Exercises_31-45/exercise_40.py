class Solution:
    def combinationSum2(self, candidates: list[int], target: int) -> list[list[int]]:
        candidates.sort()
        result = []
        path = []
        n = len(candidates)

        def backtrack(start, remaining):
            if remaining == 0:
                result.append(path.copy())
                return

            for i in range(start, n):
                value = candidates[i]

                if i > start and value == candidates[i - 1]:
                    continue

                if value > remaining:
                    break

                path.append(value)
                backtrack(i + 1, remaining - value)
                path.pop()

        backtrack(0, target)
        return result


solution = Solution()
print(solution.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
print(solution.combinationSum2([2, 5, 2, 1, 2], 5))