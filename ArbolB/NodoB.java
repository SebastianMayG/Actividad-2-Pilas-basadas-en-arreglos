public class NodoB {

    int n; // numero de claves almacenadas en el nodo
    boolean leaf; // Si el nodo es hoja (nodo hoja=true; nodo interno=false)
    int key[]; // almacena las claves en el nodo
    NodoB hijo[]; // arreglo con referencias a los hijos

     /**
     * Constructor de la clase NodoB.
     *
     * @param t Grado mínimo del Árbol B.
     */
    public NodoB(int t) {
        n = 0;
        leaf = true;
        key = new int[((2 * t) - 1)];
        hijo = new NodoB[(2 * t)];
    }
    /**
     * Muestra las claves almacenadas en el nodo.
     */
    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(key[i] + " | ");
            } else {
                System.out.print(key[i]);
            }
        }
        System.out.print("]");
    }
    /**
     * Busca una clave en el nodo.
     *
     * @param k Clave a buscar.
     * @return Índice de la clave si se encuentra, o -1 si no se encuentra.
     */
    public int buscar(int k) {
        for (int i = 0; i < n; i++) {
            if (key[i] == k) {
                return i;
            }
        }
        return -1;
    }
}