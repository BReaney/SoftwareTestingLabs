package lab03;



class GameBoard {
    private static int[][] board = new int[6][6];

    public static boolean isOnBoard(int x, int y){
        return x <= 5 && y <= 5 && x >=0 && y >=0;
    }

}
