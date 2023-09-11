
public class Main 
{
    public static void main(String[] args) 
    {
        Pila pila = new Pila();

        pila.insertar(14);
        pila.insertar(27);
        pila.insertar(1);
        pila.insertar(15);
        pila.insertar(10);
        pila.insertar(90);
        pila.insertar(71);
        pila.insertar(37);
        pila.insertar(2);
        pila.insertar(48);

        System.out.println("El tamaño de la pila es: " +  pila.getTamanio());
        
        for(int i = 1; i <5; i++)
        {
            pila.quitar();
        }
        
        System.out.println("Se quitaron 4 elementos de la cima de la pila");

        System.out.println("El tamaño de la pila es: " +  pila.getTamanio());

        System.out.println("El valor de la cima es: " + pila.obtenerCima());

        pila.vaciar();
        
        System.out.println("La pila esta vacia: " + pila.estaVacia());
    }
    
}
