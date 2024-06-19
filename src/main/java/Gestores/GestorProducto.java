package Gestores;




import entidades.Cliente;
import entidades.Producto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GestorProducto {

    public void create(String nombre, Integer precio, Integer stock) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Producto producto = new Producto(nombre, precio, stock);
        manager.persist(producto);
        manager.getTransaction().commit();
        manager.close();
    }
    public List<Producto> listaCliente() {
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Producto> lista = manager.createQuery("FROM Producto", Producto.class).getResultList();
        manager.close();
        return lista;
    }
    public void agregarAlCarrito(Cliente cliente, Producto producto){
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        cliente.getCarrito().add(producto);
        manager.persist(producto);
        manager.getTransaction().commit();
        manager.close();
    }
    public void quitarDelCarrito (Cliente cliente, Producto producto){
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        cliente.getCarrito().remove(producto);
        manager.persist(producto);
        manager.getTransaction().commit();
        manager.close();
    }
}
