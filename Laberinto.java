public class Laberinto {
      public static void main(String[] args) {
        String[] maze = {
            "S*???",
            "?*?**",
            "??*?*",
            "??*?*",
            "??**E"
        };
        Laberinto laberinto = new Laberinto();
        System.out.println(laberinto.puedoSalir(maze.length, maze));
    }
    public boolean puedoSalir(int n, String maze[]) {
        int[] coordenadasS = encontrarPosicionS(maze);
        int i = coordenadasS[0];
        int j = coordenadasS[1];
        return sePuede(maze, i, j);
    }
    private boolean sePuede(String[] maze, int x, int y) {
        boolean res = false;
        if (esValida(maze, x, y)) {
            if (maze[x].charAt(y) == 'E') {
                res = true;
            } else {
                if (maze[x].charAt(y) != '?' && maze[x].charAt(y) != '$') {
                    maze[x] = maze[x].substring(0, y) + "$" + maze[x].substring(y + 1);
                    res = sePuede(maze, x, y + 1) ||
                            sePuede(maze, x + 1, y) ||
                            sePuede(maze, x, y - 1) ||
                            sePuede(maze, x - 1, y);
                }
            }
        }
        return res;
    }
    private boolean esValida(String[] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[x].length();
    }
    private int[] encontrarPosicionS(String[] maze) {
        return encontrarPosicionS(maze, 0, 0);
    }
    private int[] encontrarPosicionS(String[] maze, int i, int j) {
        if (i == maze.length) {
            return new int[]{-1, -1};
        }
        if (j == maze[i].length()) {
            return encontrarPosicionS(maze, i + 1, 0);
        }
        if (maze[i].charAt(j) == 'S') {
            return new int[]{i, j};
        }
        return encontrarPosicionS(maze, i, j + 1);
    }
}