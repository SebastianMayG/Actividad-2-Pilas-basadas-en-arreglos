/**
 * La clase NodoArbol representa un nodo en un arbol generico.
 *
 * @param <T> El tipo de datos que se almacena en el nodo.
 */
public class NodoArbol<T> 
{
  private T dato;
  private boolean esBinario = false;
  private NodoArbol<T> primerHijo;
  private NodoArbol<T> siguienteHermano;

  /**
   * Constructor de la clase NodoArbol
   * 
   * @param dato El dato que reciben los nodos
   */
  public NodoArbol(T dato)
  {
    this.dato = dato;
    primerHijo = null;
    siguienteHermano = null;
  }

  /**
   * Agrega un hijo si es que no exite uno y si ya hay uno se agrega un nodo hermano en arbol general puede tener los nodosHijos que quiera
   * 
   * Si el arbol es binario (hasta dos nodos hijos) comprueba que haya un hijo y un nodoHermano
   * si ya tiene un nodo hermano no se puede crear otro y si no crea uno mientas siguienteHermano != null
   * @param hijo El nodo agregado llamado hijo
   */
  public void agregarHijo(NodoArbol<T> hijo)
  {
    if (primerHijo == null) {
      primerHijo = hijo;
    } else {
      NodoArbol<T> hermano = this.primerHijo;

      if (esBinario) {
        if (hermano.siguienteHermano != null) // un arbol binario debe de tener unicamente 2 hijos
        {
          System.err.println("El nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());
        } else {
          hermano.siguienteHermano = hijo; // si tiene un hijo crea un hermano de ese
        }
      } else {
        while (hermano.siguienteHermano != null) {
          hermano = hermano.siguienteHermano;
        }
        hermano.siguienteHermano = hijo;
      }
    }
  }

   /**
   * Obtiene el primer hijo del nodo
   *
   * @return El primer hijo del nodo
   */
  public NodoArbol<T> obtenerPrimerHijo() {
    return primerHijo;
  }
  /**
   * Obtiene el siguiente hermano del nodo
   *
   * @return El siguiente hermano del nodo
   */
  public NodoArbol<T> obtenerSiguienteHermano() {
    return siguienteHermano;
  }
  /**
   * Obtiene el dato almacenado en el nodo
   *
   * @return El dato almacenado en el nodo
   */
  public T getDato() {
    return dato;
  }
  /**
   * Comprueba si es arbol es binario
   * 
   * @return true si es arbol binario, false si no lo es
   */
  public boolean esBinario() {
    return esBinario;
  }
  
  public void setEsBinario(boolean esBinario) {
    this.esBinario = esBinario;
  }
  /**
   * Imprime en notacion prefija
   * Raiz Izq Der
   */
  public void imprimirEnPrefijo() {
    System.out.print(dato + "\t");
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPrefijo();
      hijo = hijo.siguienteHermano;
    }
  }
  /**
   * Imprime en notacion infija
   * Izq Raiz Der 
   */
  public void imprimirEnInfijo() {
    NodoArbol<T> hijo = primerHijo;

    if (hijo != null) {
      hijo.imprimirEnInfijo();
    }

    System.out.print(dato + "\t");
    while (hijo != null) {
      hijo = hijo.siguienteHermano;
      if (hijo != null) {
        hijo.imprimirEnInfijo();
      }
    }
  }
  /**
   * Imprime de forma posfija
   * Izq Der Raiz
   */
  public void imprimirEnPosfijo() {
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPosfijo();
      hijo = hijo.siguienteHermano;
    }

    System.out.print(dato + "\t");
  }
}
