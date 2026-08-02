/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(true) {
            int num = low + (high - low) / 2;
            int result = guess(num);

            if(result == 0) {
                return num;
            } else if(result > 0) {
                low = num + 1;
            } else {
                high = num -1;
            }
        }

    }
}