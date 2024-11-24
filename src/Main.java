import java.util.List;

class Pedido {
    private Cliente cliente;
    private List<Item> items;

    public Pedido(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public void procesarPedido() {
        System.out.println("Pedido procesado para: " + cliente.getNombre());
    }
    
    public String calcularTotal() {
        return "Calculando pedido...";
    }
}

class Cliente {
    private String nombre;
    private String direccion;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
}

class Item{
    private String name;
    private int cantidad;
    private double precio;

    public Item(String name, int cantidad, double precio) {
        this.name = name;
        this.cantidad = cantidad;
        this.precio = precio;
    }

}
    
public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Juan Perez", "Av. Principal 123");
        List<Item> items = List.of(new Item("Laptop", 2, 1000));
        Pedido pedido = new Pedido(cliente, items);

        pedido.procesarPedido();
        System.out.println("Total: " + pedido.calcularTotal());
    }
}
