public class ElMain {
    static int[][] m = new int[][]{{0,4,0,2,0,0},
                                   {4,0,3,0,3,0},
                                   {0,3,0,0,0,2},
                                   {2,0,0,0,3,0},
                                   {0,3,0,3,0,1},
                                   {0,0,2,0,1,0}};

    static int[] nPueblos = new int[]{0,1,2,3,4,5};
    static int[] minCaminos = new int[]{-1,-1,-1,-1,-1,-1};
    static int n = m.length;
    static int[] caminos = new int[n];
    static int distancia = 0;
    static int distanciaMin = 20;
    static boolean solucion = false;

    static int i;
    static int j;

    public static void backTracking(int i, int j){
        nPueblos[i] = 7;
        if (i == j) {
            solucion = true;
            if (distancia < distanciaMin){
                distanciaMin = distancia;
                System.arraycopy(caminos, 0, minCaminos, 0, minCaminos.length);
            }
        }else {
            for (int k = 0; k < n; k++){
                if (m[i][k] != 0 && nPueblos[k] != 7) {
                    caminos[k] = i;
                    distancia += m[i][k];
                    backTracking(k,j);
                    solucion = false;
                    nPueblos[k] = k;
                    caminos[k] = -1;
                    distancia -= m[i][k];
                }
            }
        }
    }

    public static void optimo(int x){
        int y = 0;
        if(x == y){
            System.out.print(" " + y);
        }else{
            optimo(minCaminos[x]);
            System.out.print(" " + x);
        }
    }

    public static void main(String[] args) {
        i = 0;
        j = 3;
        backTracking(i, j);
        System.out.println("El camino minimo desde " + i + " hasta " + j + " es: ");
        optimo(j);
        System.out.println("\nLa distancia minima recorrida es: " + distanciaMin);
    }
}
