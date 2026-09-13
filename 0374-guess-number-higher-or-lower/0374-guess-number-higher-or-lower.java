public class Solution extends GuessGame {
    public int guessNumber(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            }
            else if (result < 0) {
                // mid is higher than the answer
                right = mid - 1;
            }
            else {
                // mid is lower than the answer
                left = mid + 1;
            }
        }

        return -1;
    }
}