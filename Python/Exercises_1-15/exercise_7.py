class Solution:
    def reverse(self, x: int) -> int:

        def inverter(x: int) -> int:
            return int(str(abs(x))[::-1])

        if x < 0:
            sinal = -1
        else:
            sinal = 1

        x_inverter = sinal * inverter(x)

        if x_inverter <= pow(-2, 31) or (pow(2, 31) - 1) <= x_inverter:
            return 0
        else:
            return x_inverter

solution = Solution()
print(solution.reverse(123))
print(solution.reverse(-123))
print(solution.reverse(120))