package greedyalgorithms;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        if (m < 3) return false;
        for (int i = 1; i < m - 1; i++) {
            if (flowerbed[i] == 0 && (((flowerbed[i - 1] == 0) || (i == 0)) && ((i == m - 1) || (flowerbed[i + 1] == 0)))) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    break;
                }
            }
        }
        if (n <= 0) {
            return true;
        }
        return false;
    }
}
