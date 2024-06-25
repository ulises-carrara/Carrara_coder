package Gestores;

import entidades.Carrito;
import entidades.Cliente;
import entidades.Producto;
import jakarta.persistence.EntityManager;

public class GestorCarrito {
    public void agregarALCarrito(Integer total, Producto producto, Cliente cliente){
        try {
            EntityManager manager = GestorGenerico.getEntityManager();
            manager.getTransaction().begin();
            Carrito carrito = new Carrito();
            carrito.setTotal(total);
            carrito.setPrecio(producto.getPrecio());
            carrito.setProduct_id(producto);
            carrito.setCliente_id(cliente);
            manager.persist(carrito);
            manager.getTransaction().commit();
        }catch (Exception e){
        System.out.println(e);
    }finally {
        GestorGenerico.closeEntityManagerFactory();
    }
    }
}
