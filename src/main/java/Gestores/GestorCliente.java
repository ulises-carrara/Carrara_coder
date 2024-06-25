package Gestores;

import entidades.Cliente;
import jakarta.persistence.*;

import java.util.List;

public class GestorCliente {

    public void create(String nombre, String apellido, Integer dni, Integer edad) {

        try {
            EntityManager manager = GestorGenerico.getEntityManager();
            manager.getTransaction().begin();
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEdad(edad);
            cliente.setDni(dni);
            manager.persist(cliente);
            manager.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            GestorGenerico.closeEntityManagerFactory();
        }

    }
    public Cliente buscarId (Integer id){
        EntityManager manager =GestorGenerico.getEntityManager();
        Cliente cliente = null;
        try {
            cliente = manager.find(Cliente.class, id);
            return cliente;
        }catch (Exception e){
            System.out.println(e);
        }finally {
            GestorGenerico.closeEntityManagerFactory();
            return cliente;
        }
    }

    public List<Cliente> listaCliente() {
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Cliente> lista = null;
       try {
           lista = manager.createQuery("FROM Cliente", Cliente.class).getResultList();
            return lista;
       }catch (Exception e){
           System.out.println(e);
       }finally {
           GestorGenerico.closeEntityManagerFactory();
           return lista;
       }
    }

    public void delete(Integer id) {
        EntityManager manager = GestorGenerico.getEntityManager();
        try {
            manager.getTransaction().begin();
            Cliente cliente = manager.find(Cliente.class, id);
            if (cliente != null) {
                manager.remove(cliente);
                manager.getTransaction().commit();
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            GestorGenerico.closeEntityManagerFactory();
        }
    }

    public void update(Integer id, String nombre, String apellido, Integer dni, Integer edad) {
        EntityManager manager = GestorGenerico.getEntityManager();
    try {
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
        }catch (Exception e){
            System.out.println(e);
        }finally {
            GestorGenerico.closeEntityManagerFactory();
        }

    }
}