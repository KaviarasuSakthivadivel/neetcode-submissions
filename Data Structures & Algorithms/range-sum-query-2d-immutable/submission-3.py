class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        rowL = len(matrix)
        colL = len(matrix[0])

        self.prefixSum = [[0] * (colL + 1) for _ in range(rowL)]

        for row in range(rowL):
            for col in range(colL):
                self.prefixSum[row][col + 1] = self.prefixSum[row][col] + matrix[row][col]


    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        sum_val = 0

        for row in range(row1, row2 + 1):
            sum_val += (self.prefixSum[row][col2 + 1] - self.prefixSum[row][col1])
        
        return sum_val
        


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)