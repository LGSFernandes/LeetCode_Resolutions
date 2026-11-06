class Solution:
    def solveSudoku(self, board: list[list[str]]) -> None:
        rows = [0] * 9
        cols = [0] * 9
        boxes = [0] * 9
        empty = []
        full = (1 << 9) - 1

        for r in range(9):
            for c in range(9):
                value = board[r][c]

                if value == '.':
                    empty.append((r, c))
                else:
                    bit = 1 << (ord(value) - ord('1'))
                    box = (r // 3) * 3 + c // 3

                    rows[r] |= bit
                    cols[c] |= bit
                    boxes[box] |= bit

        def backtrack(pos):
            if pos == len(empty):
                return True

            best = pos
            best_mask = 0
            min_options = 10

            for idx in range(pos, len(empty)):
                r, c = empty[idx]
                box = (r // 3) * 3 + c // 3

                mask = full & ~(rows[r] | cols[c] | boxes[box])
                options = mask.bit_count()

                if options == 0:
                    return False

                if options < min_options:
                    min_options = options
                    best = idx
                    best_mask = mask

            empty[pos], empty[best] = empty[best], empty[pos]

            r, c = empty[pos]
            box = (r // 3) * 3 + c // 3
            candidates = best_mask

            while candidates:
                bit = candidates & -candidates
                candidates ^= bit

                board[r][c] = str(bit.bit_length())

                rows[r] |= bit
                cols[c] |= bit
                boxes[box] |= bit

                if backtrack(pos + 1):
                    return True

                rows[r] ^= bit
                cols[c] ^= bit
                boxes[box] ^= bit

                board[r][c] = '.'

            empty[pos], empty[best] = empty[best], empty[pos]

            return False

        backtrack(0)


solution = Solution()
print(solution.solveSudoku(
    [
        ["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
    ]
))