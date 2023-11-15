public class Main {
    public static void main(String[] args) {
        // grado minimo del Arbol B es t=3
        // Cada nodo soporta 2t hijos y 2t-1 claves
        // Se crea el arbol B segun t
        ArbolB arbolB = new ArbolB();

        // Valores a ingresar primera ronda
        int[] valoresUno = {1,5,7,24,10,50,30,40,4,2,65,123};
        for (int i = 0; i < valoresUno.length; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar(valoresUno[i]);
        }

        // Mostrar el estado del árbol B
        System.out.println("ESTADO ARBOL B");
        arbolB.MostrarArbol();
        System.out.println("");

        // Buscar nodos en el árbol
        arbolB.buscarNodo(30);
        arbolB.buscarNodo(60);

        arbolB.eliminar(50);

        System.out.println("ESTADO ARBOL B");
        arbolB.MostrarArbol();
    }
}