package Gestores;

import entidades.Cliente;
import jakarta.persistence.*;

import java.util.List;

public class GestorCliente {

    public void create(String nombre, String apellido, Integer dni, Integer edad) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Cliente cliente = new Cliente(nombre, apellido, dni, edad);
        manager.persist(cliente);
        manager.getTransaction().commit();
        manager.close();
    }

    public List<Cliente> listaCliente() {
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Cliente> lista = manager.createQuery("FROM Cliente", Cliente.class).getResultList();
        manager.close();
        return lista;
    }

    public void delete(Integer id) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Cliente cliente = manager.find(Cliente.class, id);
        if (cliente != null) {
            manager.remove(cliente);
            manager.getTransaction().commit();
        }
        manager.close();
    }

    public void update(Integer id, String nombre, String apellido, Integer dni, Integer edad) {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Cliente cliente = manager.find(Cliente.class, id);
        if (cliente != null) {
            if (nombre != null) {
                cliente.setNombre(nombre);
            }
            if (apellido != null) {
                cliente.setApellido(apellido);
            }
            if (dni != null){
                cliente.setDni(dni);
            }
            if (edad != null){
                cliente.setEdad(edad);
            }
            manager.merge(cliente);
            manager.getTransaction().commit();
        }
        manager.close();
    }
}