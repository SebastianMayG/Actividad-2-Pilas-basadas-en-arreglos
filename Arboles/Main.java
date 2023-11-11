public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Arbol general");
        
        Arbol <String> arbol = new Arbol<>("A",false);

        NodoArbol<String> nodoB = new NodoArbol<String>("B");
        NodoArbol<String> nodoC = new NodoArbol<String>("C");
        NodoArbol<String> nodoD = new NodoArbol<String>("D");

        arbol.agregarNodoArbol(arbol.obtenerRaiz(), nodoB);
        arbol.agregarNodoArbol(arbol.obtenerRaiz(), nodoC);
        arbol.agregarNodoArbol(arbol.obtenerRaiz(), nodoD);

        NodoArbol<String> nodoE = new NodoArbol<String>("E");
        NodoArbol<String> nodoF = new NodoArbol<String>("F");

        arbol.agregarNodoArbol(nodoB, nodoE);
        arbol.agregarNodoArbol(nodoB, nodoF);

        NodoArbol<String> nodoJ = new NodoArbol<String>("J");
        NodoArbol<String> nodoK = new NodoArbol<String>("K");
        NodoArbol<String> nodoL = new NodoArbol<String>("L");

        arbol.agregarNodoArbol(nodoF, nodoJ);
        arbol.agregarNodoArbol(nodoF, nodoK);
        arbol.agregarNodoArbol(nodoF, nodoL);

        NodoArbol<String> nodoG = new NodoArbol<String>("G");
        NodoArbol<String> nodoH = new NodoArbol<String>("H");
        NodoArbol<String> nodoI = new NodoArbol<String>("I");

        arbol.agregarNodoArbol(nodoD, nodoG);
        arbol.agregarNodoArbol(nodoD, nodoH);
        arbol.agregarNodoArbol(nodoD, nodoI);

        NodoArbol<String> nodoM = new NodoArbol<String>("M");

        arbol.agregarNodoArbol(nodoG, nodoM);

        NodoArbol<String> nodoP = new NodoArbol<String>("P");
        NodoArbol<String> nodoQ = new NodoArbol<String>("Q");

        arbol.agregarNodoArbol(nodoM, nodoP);
        arbol.agregarNodoArbol(nodoM, nodoQ);

        NodoArbol<String> nodoN = new NodoArbol<String>("N");
        NodoArbol<String> nodoO = new NodoArbol<String>("O");

        arbol.agregarNodoArbol(nodoI, nodoN);
        arbol.agregarNodoArbol(nodoI, nodoO);

        arbol.imprimirArbol(Recorrido.PREFIJO);
        arbol.imprimirArbol(Recorrido.INFIJO);
        arbol.imprimirArbol(Recorrido.POSFIJO);

        System.out.println("");
        arbol.estaVacio();

        System.out.println("Arbol binario");

        Arbol <String> arbolbinario = new Arbol<>("A",true);

        NodoArbol<String> nodoBinarioB = new NodoArbol<String>("B");
        arbolbinario.agregarNodoArbol(arbolbinario.obtenerRaiz(), nodoBinarioB);

        NodoArbol<String> nodoBinarioE = new NodoArbol<String>("E");
        arbolbinario.agregarNodoArbol(nodoBinarioB, nodoBinarioE);

        NodoArbol<String> nodoBinarioF = new NodoArbol<String>("F");
        arbolbinario.agregarNodoArbol(nodoBinarioE, nodoBinarioF);

        NodoArbol<String> nodoBinarioJ = new NodoArbol<String>("J");
        arbolbinario.agregarNodoArbol(nodoBinarioF, nodoBinarioJ);

        NodoArbol<String> nodoBinarioK = new NodoArbol<String>("K");
        arbolbinario.agregarNodoArbol(nodoBinarioJ, nodoBinarioK);
        NodoArbol<String> nodoBinarioL = new NodoArbol<String>("L");
        arbolbinario.agregarNodoArbol(nodoBinarioK, nodoBinarioL);

        NodoArbol<String> nodoBinarioC = new NodoArbol<String>("C");
        arbolbinario.agregarNodoArbol(nodoBinarioB, nodoBinarioC);

        NodoArbol<String> nodoBinarioD = new NodoArbol<String>("D");
        arbolbinario.agregarNodoArbol(nodoBinarioC, nodoBinarioD);
        
        NodoArbol<String> nodoBinarioG = new NodoArbol<String>("G");
        arbolbinario.agregarNodoArbol(nodoBinarioD, nodoBinarioG);

        NodoArbol<String> nodoBinarioM = new NodoArbol<String>("M");
        arbolbinario.agregarNodoArbol(nodoBinarioG, nodoBinarioM);

        NodoArbol<String> nodoBinarioP = new NodoArbol<String>("P");
        arbolbinario.agregarNodoArbol(nodoBinarioM, nodoBinarioP);

        NodoArbol<String> nodoBinarioQ = new NodoArbol<String>("Q");
        arbolbinario.agregarNodoArbol(nodoBinarioP, nodoBinarioQ);

        NodoArbol<String> nodoBinarioH = new NodoArbol<String>("H");
        arbolbinario.agregarNodoArbol(nodoBinarioG, nodoBinarioH);

        NodoArbol<String> nodoBinarioI = new NodoArbol<String>("I");
        arbolbinario.agregarNodoArbol(nodoBinarioH, nodoBinarioI);

        NodoArbol<String> nodoBinarioN = new NodoArbol<String>("N");
        arbolbinario.agregarNodoArbol(nodoBinarioI, nodoBinarioN);

        NodoArbol<String> nodoBinarioO = new NodoArbol<String>("O");
        arbolbinario.agregarNodoArbol(nodoBinarioN, nodoBinarioO);

        arbolbinario.imprimirArbol(Recorrido.PREFIJO);
        arbolbinario.imprimirArbol(Recorrido.INFIJO);
        arbolbinario.imprimirArbol(Recorrido.POSFIJO);

        System.out.println("");

        if(arbolbinario.estaVacio())
        {
            System.out.println("El arbol esta vacio");
        }else{
            System.out.println("El arbol no esta vacio");
        }
        
        System.out.println("La altura del árbol es: " + arbol.obtenerAltura(arbolbinario.obtenerRaiz()));

        arbolbinario.imprimirSubArbol(nodoBinarioG);//En este parametro se cambia el nodo que se quiere imprimir como subArbol
    }
}
