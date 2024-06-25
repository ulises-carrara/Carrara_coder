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
    public List<Producto> listaProducto() {
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Producto> lista = manager.createQuery("FROM Producto", Producto.class).getResultList();
        manager.close();
        return lista;
    }
    public Producto buscarId (Integer id){
        EntityManager manager = GestorGenerico.getEntityManager();
        Producto producto = null;
        try {
            producto = manager.find(Producto.class, id);
            return producto;
        }catch (Exception e){
            System.out.println(e);
        }finally {
            GestorGenerico.closeEntityManagerFactory();
            return producto;
        }
    }
//    public void agregarAlCarrito(Cliente cliente, Producto producto){
//        EntityManager manager = GestorGenerico.getEntityManager();
//        manager.getTransaction().begin();
//        cliente.getCarrito().add(producto);
//        manager.persist(producto);
//        manager.getTransaction().commit();
//        manager.close();
//    }
    public void quitarDelCarrito (Cliente cliente, Producto producto){
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        cliente.getCarrito().remove(producto);
        manager.persist(producto);
        manager.getTransaction().commit();
        manager.close();
    }
}
