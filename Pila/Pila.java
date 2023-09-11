
public class Pila 
{
    private Nodo cima;
    private int tamanio;
    
    public void Pila()
    {
        cima = null;
    }
    
    public void insertar(int dato) 
    {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setNodo(cima);
        cima = nuevoNodo;
        tamanio++;
    }

    public void quitar() 
    {
        if (cima != null) 
        {
            cima = cima.getNodo();
            tamanio--; 
        } else 
        {
            System.out.println("La pila está vacía, no se puede quitar ningún elemento.");
        }
    }
    
    public boolean estaVacia()
    {
        if(cima == null)
        {
            return true;
        }else
        {
            return false;
        }  
    }

    public void vaciar()
    {
        cima = null;
        tamanio = 0;
        System.out.println("Se vació la pila");
    }

    public int obtenerCima()
    {
        return cima.getDato();
    }

    public void setCima(Nodo cima)
    {
        this.cima = cima;
    }
    
    public int getTamanio()
    {
        return tamanio;
    }

    public void setTamanio(int tamanio)
    {
        this.tamanio = tamanio;
    } 
}