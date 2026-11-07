class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return "0"

        m, n = len(num1), len(num2)
        result = [0] * (m + n)

        for i in range(m - 1, -1, -1):
            d1 = ord(num1[i]) - 48

            for j in range(n - 1, -1, -1):
                d2 = ord(num2[j]) - 48
                result[i + j + 1] += d1 * d2

        for i in range(m + n - 1, 0, -1):
            result[i - 1] += result[i] // 10
            result[i] %= 10

        start = 0

        while start < m + n - 1 and result[start] == 0:
            start += 1

        return ''.join(map(str, result[start:]))


solution = Solution()
print(solution.multiply("2", "3"))
print(solution.multiply("123", "456"))