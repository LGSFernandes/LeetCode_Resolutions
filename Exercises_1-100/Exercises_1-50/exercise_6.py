class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1 or numRows >= len(s):
            return s

        rows = [""] * numRows
        
        current_row = 0
        direction = -1  
        to_down = False

        for char in s:
            rows[current_row] += char
            
            if current_row == 0 or current_row == numRows - 1:
                to_down = not to_down
            
            if to_down:
                current_row += 1
            else:
                current_row -= 1

        return "".join(rows)

solution = Solution()
print(solution.convert("PAYPALISHIRING", 3))
print(solution.convert("PAYPALISHIRING", 4))