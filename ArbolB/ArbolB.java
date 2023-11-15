public class ArbolB {
    NodoB raiz;
    int t;

    /**
     * Constructor de la clase ArbolB.
     * Inicializa la raíz del árbol con el grado mínimo especificado.
     */
    public ArbolB() {
        this.t = 3; // Valor predeterminado para el grado mínimo del Árbol B (puedes ajustarlo segun tus necesidades)
        this.raiz = new NodoB(t);
    }

    /**
     * Método para insertar un valor en el Árbol B.
     *
     * @param key Valor a insertar en el árbol.
     */
    public void insertar(int key) {
        NodoB r = raiz;
        // Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoB s = new NodoB(t);
            raiz = s;
            s.leaf = false;
            s.n = 0;
            s.hijo[0] = r;
            dividir(s, 0, r);
            nonFullInsert(s, key);
        } else {
            nonFullInsert(r, key);
        }
    }

    /**
     * Método para dividir un nodo.
     *
     * @param x Nodo padre que contiene el nodo a dividir.
     * @param i Índice del nodo a dividir en el nodo padre.
     * @param y Nodo a dividir.
     */
    private void dividir(NodoB x, int i, NodoB y) {
        // Nodo temporal que sera el hijo i + 1 de x
        NodoB temp = new NodoB(t);
        temp.leaf = y.leaf;
        temp.n = (t - 1);

        // Copia las ultimas (t - 1) claves del nodo y al inicio del nodo z // z =
        for (int j = 0; j < (t - 1); j++) {
            temp.key[j] = y.key[(j + t)];
        }

        // Si no es hoja hay que reasignar los nodos hijos
        if (!y.leaf) {
            for (int k = 0; k < t; k++) {
                temp.hijo[k] = y.hijo[(k + t)];
            }
        }

        y.n = (t - 1); 
        // Mueve los hijos de x para darle espacio a z
        for (int j = x.n; j > i; j--) {
            x.hijo[(j + 1)] = x.hijo[j];
        }
        // Reasigna el hijo (i+1) de x // x = | | | | | |
        x.hijo[(i + 1)] = temp;
        // Mueve las claves de x
        for (int j = x.n; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }

        // Agrega la clave situada en la mediana
        x.key[i] = y.key[(t - 1)]; 
        x.n++; 
    }
    /**
     * Método para insertar en un nodo no lleno.
     *
     * @param x   Nodo en el cual insertar.
     * @param key Valor a insertar.
     */
    private void nonFullInsert(NodoB x, int key) {
        // Si es una hoja
        if (x.leaf) {
            int i = x.n; // cantidad de valores del nodo
            // busca la posicion i donde asignar el valor
            while (i >= 1 && key < x.key[i - 1]) {
                x.key[i] = x.key[i - 1];// Desplaza los valores mayores a key
                i--;
            }

            x.key[i] = key;// asigna el valor al nodo
            x.n++; // aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            // Busca la posicion del hijo
            while (j < x.n && key > x.key[j]) {
                j++;
            }

            // Si el nodo hijo esta lleno lo separa
            if (x.hijo[j].n == (2 * t - 1)) {
                dividir(x, j, x.hijo[j]);

                if (key > x.key[j]) {
                    j++;
                }
            }

            nonFullInsert(x.hijo[j], key);
        }
    }

    /**
     * Método para mostrar el Árbol B.
     */
    public void MostrarArbol() {
        print(raiz);
    }

    /**
     * Método para imprimir en preorden.
     *
     * @param n Nodo desde el cual empezar a imprimir.
     */
    private void print(NodoB n) {
        n.imprimir();

        // Si no es hoja
        if (!n.leaf) {
            // recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.hijo[j] != null) {
                    System.out.println();
                    print(n.hijo[j]);
                }
            }
        }
    }
    /**
     * Método para buscar un nodo por clave.
     *
     * @param num Valor a buscar en el árbol.
     */
    public void buscarNodo(int num) {
        NodoB temp = raiz;

        while (temp != null) {
            int i = 0;
            // Incrementa el índice mientras el valor de la clave del nodo sea menor
            while (i < temp.n && num > temp.key[i]) {
                i++;
            }

            // Si la clave es igual, se ha encontrado el nodo
            if (i < temp.n && num == temp.key[i]) {
                System.out.println("Se ha encontrado el nodo con el valor " + num);
                return;
            }

            // Si llegamos hasta aquí, hay que buscar los hijos
            // Se revisa primero si tiene hijos
            if (temp.leaf) {
                break; // No hay más nodos que buscar
            } else {
                // Si tiene hijos, hace una llamada recursiva
                temp = temp.hijo[i];
            }
        }

        System.out.println("No se ha encontrado un nodo con el valor " + num);
    }
    /**
     * Método para eliminar un valor del Árbol B.
     *
     * @param key Valor a eliminar del árbol.
     */
    public void eliminar(int key) {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        eliminar(raiz, key);

        if (raiz.n == 0 && !raiz.leaf) {
            raiz = raiz.hijo[0];
        }
    }

    // Método auxiliar para la eliminación
    private void eliminar(NodoB x, int key) {
        int idx = x.buscar(key);

        if (idx != -1) {
            eliminarEnNodo(x, idx);
        } else {
            int i = 0;
            while (i < x.n && key > x.key[i]) {
                i++;
            }

            if (x.leaf) {
                System.out.println("El valor " + key + " no está presente en el árbol.");
                return;
            }
            NodoB hijo = x.hijo[i];

            if (hijo.n == t - 1) {
                eliminar(x, key);
            } else {
                eliminar(hijo, key);
            }
        }
    }

    private void eliminarEnNodo(NodoB x, int idx) {
        System.out.println("Nodo " + x.key[idx] + " eliminado");
        // Caso 1: La clave a eliminar está en un nodo hoja
        if (x.leaf) {
            eliminarEnNodoHoja(x, idx);
        }
        // Caso 2: La clave a eliminar está en un nodo interno
        else {
            eliminarEnNodoInterno(x, idx);
        }
    }
    
    private void eliminarEnNodoHoja(NodoB x, int idx) {
        // Elimina la clave en la posición idx y ajusta las demás claves
        for (int i = idx; i < x.n - 1; i++) {
            x.key[i] = x.key[i + 1];
        }
        x.n--;
    }
    
    private void eliminarEnNodoInterno(NodoB x, int idx) {
        int key = x.key[idx];
    
        // Caso 2a: Si el hijo que precede a key (hijo[idx]) tiene al menos t claves
        if (x.hijo[idx].n >= t) {
            // Encuentra el predecesor inmediato 'pred' de key en el subárbol izquierdo
            int pred = obtenerPredecesor(x, idx);
            // Recursivamente elimina pred en el subárbol izquierdo
            eliminar(x.hijo[idx], pred);
            // Reemplaza key por pred en el nodo actual
            x.key[idx] = pred;
        }
        // Caso 2b: Si el hijo que precede a key tiene menos de t claves
        else if (x.hijo[idx + 1].n >= t) {
            // Encuentra el sucesor inmediato 'succ' de key en el subárbol derecho
            int succ = obtenerSucesor(x, idx);
            // Recursivamente elimina succ en el subárbol derecho
            eliminar(x.hijo[idx + 1], succ);
            // Reemplaza key por succ en el nodo actual
            x.key[idx] = succ;
        }
        // Caso 2c: Ambos hijos tienen menos de t claves
        else {
            // Combina el hijo[idx] y el hijo[idx + 1] en un solo hijo
            combinarHijos(x, idx);
            // Recursivamente elimina key en el nuevo hijo combinado
            eliminar(x.hijo[idx], key);
        }
    }
    
    private int obtenerPredecesor(NodoB x, int idx) {
        // Encuentra y devuelve la clave más a la derecha en el subárbol izquierdo de hijo[idx]
        NodoB temp = x.hijo[idx];
        while (!temp.leaf) {
            temp = temp.hijo[temp.n];
        }
        return temp.key[temp.n - 1];
    }
    
    private int obtenerSucesor(NodoB x, int idx) {
        // Encuentra y devuelve la clave más a la izquierda en el subárbol derecho de hijo[idx + 1]
        NodoB temp = x.hijo[idx + 1];
        while (!temp.leaf) {
            temp = temp.hijo[0];
        }
        return temp.key[0];
    }
    
    private void combinarHijos(NodoB x, int idx) {
        // Combina el hijo[idx] y el hijo[idx + 1] en un solo hijo
        NodoB hijo = x.hijo[idx];
        NodoB hermano = x.hijo[idx + 1];
    
        // Transfiere la clave en el nodo actual al hijo[idx]
        hijo.key[t - 1] = x.key[idx];
        // Transfiere las claves desde el hermano a hijo[idx]
        for (int i = 0; i < hermano.n; i++) {
            hijo.key[i + t] = hermano.key[i];
        }
        // Transfiere los hijos desde el hermano a hijo[idx]
        if (!hermano.leaf) {
            for (int i = 0; i <= hermano.n; i++) {
                hijo.hijo[i + t] = hermano.hijo[i];
            }
        }
    
        // Ajusta las claves y los hijos en el nodo actual después de la combinación
        for (int i = idx + 1; i < x.n; i++) {
            x.key[i - 1] = x.key[i];
        }
        for (int i = idx + 2; i <= x.n; i++) {
            x.hijo[i - 1] = x.hijo[i];
        }
    
        x.n--;
    
        // Libera el hermano después de la combinación
        hermano = null;
    }

}