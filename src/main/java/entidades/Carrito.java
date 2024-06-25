package entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Carrito {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer total;
    private double precio;


    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto_id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente_id;




    public Carrito(){}

    public Carrito(Integer total, double precio) {
        this.total = total;
        this.precio = precio;
    }


    public Producto getProduct_id() {
        return producto_id;
    }

    public void setProduct_id(Producto product_id) {
        this.producto_id = product_id;
    }

    public Cliente getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrito carrito = (Carrito) o;
        return Double.compare(precio, carrito.precio) == 0 && Objects.equals(id, carrito.id) && Objects.equals(total, carrito.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, precio);
    }
}
