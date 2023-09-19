public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("Lista doblemente enlazada");
        
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

        lista.insertar(5);
        lista.insertar(59);
        lista.insertar(91);
        lista.insertar(-17);
        lista.insertar(73);
        lista.insertar(34);
        lista.insertar(40);

        lista.eliminar(2);
        lista.eliminar(3);

        System.out.println("El indice #3 de la lista es: " + lista.obtener(3));
    }    
}
