public class textOverlayOnHerolmage {
    static int[] textOverlayOnHeroImage(final int[][] image, int height, int width) {
        class Helper {

            int columnSum(int x, int y1, int y2) {
                int result = 0;
                for (int y = y1; y < y2; y++) {
                    result += image[y][x];
                }
                return result;
            };

            int rowSum(int y, int x1, int x2) {
                int result = 0;
                for (int x = x1; x < x2; x++) {
                    result += image[y][x];
                }
                return result;
            }
        };

        int bestSum = -1;
        int sum = 0;
        int lastRowLeftmostSum = 0;
        int[] bestPos = null;

        Helper h = new Helper();

        for (int i = 0; i + height <= image.length; i++) {
            for (int j = 0; j + width <= image[0].length; j++) {
                if (i == 0 && j == 0) {
                    for (int y = 0; y < height; y++) {
                        sum += h.rowSum(y, 0, width);
                    }
                    lastRowLeftmostSum = sum;
                }
                else if (j == 0) {
                // блок, котоырй нужно было изменить
                    sum=0;
                    for (int y = i; y < i+height; ++y) {
                        sum += h.rowSum(y, 0, width);
                    }

                    lastRowLeftmostSum = sum;
                }
                //...
                else {
                    sum = sum - h.columnSum(j - 1, i, i + height)
                            + h.columnSum(j + width - 1, i, i + height);
                }
                if (sum > bestSum) {
                    bestSum = sum;
                    bestPos = new int[] {i, j};
                }
            }
        }
        return bestPos;
    }
}
