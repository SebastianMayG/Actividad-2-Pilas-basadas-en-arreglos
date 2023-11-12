/**
 * La clase Arbol<T> representa un arbol general que puede ser un arbol binario
 * o no binario
 * utilizado para almacenar datos de cualquier tipo
 *
 * @param <T> El tipo de datos que se almacenara en el arbol.
 */
public class Arbol<T> {
  private NodoArbol<T> raiz;

  private boolean esBinario = false;

  /**
   * Constructor de la clase Arbol el cual define la raiz y comprueba es binario o
   * general
   * 
   * @param dato      El dato que almacenara la raiz del arbol
   * @param esBinario Indica si el arbol es binario o no
   */
  public Arbol(T dato, boolean esBinario) {
    raiz = new NodoArbol<T>(dato);
    raiz.setEsBinario(esBinario);
    this.esBinario = esBinario;
  }

  /**
   * Obtiene la raiz del arbol
   *
   * @return La raiz del arbol
   */
  public NodoArbol<T> obtenerRaiz() {
    return raiz;
  }

  /**
   * Comprueba si el arbol es binario o no binario
   * 
   * @return true si es binario, false si no lo es
   */
  public boolean esBinario() {
    return esBinario;
  }

  /**
   * Agrega un nodo al árbol como hijo del nodo especificado.
   *
   * @param nodoRaiz     El nodo al que se agregara el nuevo nodo.
   * @param nodoAgregado El nuevo nodo que se agregara al arbol.
   */
  public void agregarNodoArbol(NodoArbol<T> nodoRaiz, NodoArbol<T> nodoAgregado) // si es binario agrega un nodo si no
                                                                                 // una raiz
  {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);
    }

    nodoRaiz.agregarHijo(nodoAgregado);
  }

  /**
   * imprime el tipo de nomenclatura especificado
   * 
   * @param recorrido tipo de recorrido (PREFIJO, INFIJO, POSFIJO)
   */
  public void imprimirArbol(Recorrido recorrido) {
    switch (recorrido.ordinal()) {
      case 0:
        System.out.println("Prefijo: ");
        raiz.imprimirEnPrefijo();
        break;

      case 1:
        System.out.println("\nInfijo: ");
        raiz.imprimirEnInfijo();
        break;

      case 2:
        System.out.println("\nPosfijo: ");
        raiz.imprimirEnPosfijo();
        break;

      default:
        break;
    }
  }

  /**
   * Comprueba si el arbol esta vacio
   * 
   * @return true si esta vacio, false lo contrario
   */
  public boolean estaVacio() {
    return raiz == null;
  }

  /**
   * Obtiene la altura del arbol
   *
   * @return La altura del arbol
   */
  public int obtenerAltura() {
    return obtenerAltura(this.raiz);
  }

  /**
   * Metodo recursivo para calcular la altura del arbol
   *
   * @param nodo El nodo actual
   * @return La altura del arbol
   */
  private int obtenerAltura(NodoArbol<T> nodo) {
    if (nodo == null) {
      return 0;
    } else {
      int maxAltura = 0;
      NodoArbol<T> hijo = nodo.obtenerPrimerHijo();
      while (hijo != null) {
        int alturaHijo = obtenerAltura(hijo);
        if (alturaHijo > maxAltura) {
          maxAltura = alturaHijo;
        }
        hijo = hijo.obtenerSiguienteHermano();
      }
      return maxAltura + 1;
    }
  }

  /**
   * Si el nodo es null no imprime un subarbol
   * Al contrario imprime desde el nodo que el usuario paso en el metodo
   * 
   * @param nodo Pasar como parametro desde que nodo imprimir
   */
  public void imprimirSubArbol(NodoArbol<T> nodo) {
    if (nodo == null) {
      System.out.println("El nodo proporcionado es nulo");

    } else {
      System.out.println("Subarbol del nodo: " + nodo.getDato());
      System.out.println("Prefijo:");
      nodo.imprimirEnPrefijo();
      System.out.println("\nInfijo:");
      nodo.imprimirEnInfijo();
      System.out.println("\nPosfijo:");
      nodo.imprimirEnPosfijo();
    }
  }

}