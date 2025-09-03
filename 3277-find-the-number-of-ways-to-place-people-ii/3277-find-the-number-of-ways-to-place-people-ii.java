class Solution {
    public int numberOfPairs(int[][] points) {
        int result = 0;
        int xa, ya, xb, yb;
        int n = points.length;
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1]; 
            }
        });
        // for (int l = 0; l < n; l++) {
        //     System.out.println("point: " + Arrays.toString(points[0]) + " , " + Arrays.toString(points[1]));
        // }
        for (int i = 0; i < n; i++) {
            xa = points[i][0];
            ya = points[i][1];
            for (int j = i + 1; j < n; j++) {
                xb = points[j][0];
                yb = points[j][1];
                if (checkUpperLeft(i, j, xa, xb, ya, yb) && checkNoPoint(i, j, xa, xb, ya, yb, points)) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean checkUpperLeft(int i, int j, int xa, int xb, int ya, int yb) {
        if (i != j) {
            if (ya >= yb) {
                return true;
            }
        }

        // System.out.println("xa: " + xa + " , " + "xb: " + xb + " , " + "ya: " + ya + " , " + "yb: " + yb);

        // System.out.println("upperleft failed");
        // System.out.println("i: " + i + " , j: " + j);
        return false;
    }

    public boolean checkNoPoint(int i, int j, int xa, int xb, int ya, int yb, int[][] points) {
        int n = points.length;
        for (int k = i + 1; k < j; k++) {
            if (k != i && k != j) {
                int kx = points[k][0];
                int ky = points[k][1];
                if (kx <= xb && kx >= xa && ky <= ya && ky >= yb) {
                    //System.out.println("rectangle failed");
                    return false;
                }
            }
        }
        return true;
    }
}