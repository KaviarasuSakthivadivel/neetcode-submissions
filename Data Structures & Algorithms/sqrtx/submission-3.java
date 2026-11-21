class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        int result = 0;

        while(l <= r) {
            int m = l + (r - l) / 2;
            long square = (long) m * m;
            if(square < x) {
                result = m;
                l = m + 1;
            } else if(square > x) {
                r = m - 1;
            } else {
                return m;
            }
        }

        return result;
    }
}