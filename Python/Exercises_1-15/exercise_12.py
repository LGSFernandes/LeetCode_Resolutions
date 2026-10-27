class Solution:
    def intToRoman(self, num: int) -> str:
        roman_values = [
            (1000, "M"),
            (900, "CM"),
            (500, "D"),
            (400, "CD"),
            (100, "C"),
            (90, "XC"),
            (50, "L"),
            (40, "XL"),
            (10, "X"),
            (9, "IX"),
            (5, "V"),
            (4, "IV"),
            (1, "I")
        ]
        
        result = []
        
        for valor, symbol in roman_values:
            if num == 0:
                break
                
            quantity = num // valor
            
            result.append(symbol * quantity)
            
            num %= valor
            
        return "".join(result)

# Testando:
solution = Solution()
print(solution.intToRoman(3749))
print(solution.intToRoman(58))
print(solution.intToRoman(1994))