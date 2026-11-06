class Solution:
    def countAndSay(self, n: int) -> str:
        current = "1"

        for _ in range(n - 1):
            result = []
            i = 0

            while i < len(current):
                j = i + 1

                while j < len(current) and current[j] == current[i]:
                    j += 1

                result.append(str(j - i))
                result.append(current[i])

                i = j

            current = "".join(result)

        return current


solution = Solution()
print(solution.countAndSay(4))
print(solution.countAndSay(1))