class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        if not s:
            return 0
        
        sign = 1
        start = 0
        
        if s[0] == "-":
            sign = -1
            start = 1
        elif s[0] == "+":
            start = 1
            
        result = 0
        
        for i in range(start, len(s)):
            if not s[i].isdigit():
                break
            
            digit = int(s[i])
            result = result * 10 + digit
            
        result *= sign
        
        INT_MIN = -2**31
        INT_MAX = 2**31 - 1
        
        if result < INT_MIN:
            return INT_MIN
        if result > INT_MAX:
            return INT_MAX
            
        return result

solution = Solution()
print(solution.myAtoi("42"))
print(solution.myAtoi("   -42"))
print(solution.myAtoi("1337c0d3"))
print(solution.myAtoi("0-1"))
print(solution.myAtoi("words and 987"))