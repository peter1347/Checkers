public class Setup {
    public int[][] defaultBoard() {
        int[][] setup = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int y = 0; y != 4; y++)
                if (y % 2 != 0) {

                    if (i % 2 != 0) {
                        setup[y][i] = 1;
                    } else {
                        setup[y][i] = 0;
                    }
                } else {
                    if (i % 2 != 0) {
                        setup[y][i] = 0;
                    } else {
                        setup[y][i] = 1;
                    }
                }
        }
        for (int j = 0; j < 10; j++) {
            for (int y2 = 6; y2 != 9; y2++) {
                if (y2 % 2 != 0) {

                    if (j % 2 != 0) {
                        setup[y2][j] = 2;
                    } else {
                        setup[y2][j] = 0;
                    }
                } else {
                    if (j % 2 != 0) {
                        setup[y2][j] = 0;
                    } else {
                        setup[y2][j] = 2;
                    }
                }
            }

        }
        return setup;

    }
}

