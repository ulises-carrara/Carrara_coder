import Gestores.GestorCliente;
import Gestores.GestorProducto;
import entidades.Cliente;

public class Main {
    public static void main(String[] args) {
        GestorCliente gestorCliente = new GestorCliente();
        GestorProducto gestorProducto = new GestorProducto();

        gestorProducto.create("Pantalon", 1900, 120);
        gestorProducto.create("zapatillas", 2500, 150);
        gestorProducto.create("remera", 1200, 100);

        gestorCliente.create("ulises", "carrara", 42217903, 25);
        gestorCliente.create("julio", "carrara", 36217903, 43);
        gestorCliente.create("mara", "pelegrina", 32217903, 45);
        
    }
}
