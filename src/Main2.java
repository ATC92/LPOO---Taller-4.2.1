import java.util.List;

class Pedido {
    private List<Item> items;
    private String estado;

    public Pedido(List<Item> items, String estado)
    {
        this.items = items;
        this.estado = estado;
    }

    protected double calcularTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrecio() * item.getCantidad();
        }
        return total;
    }

    protected void aplicarDescuento(double porcentaje) {
        double descuento = calcularTotal() * (porcentaje / 100);
        for (Item item : items) {
            item.setPrecio(item.getPrecio() - (item.getPrecio() * (porcentaje / 100)) * descuento);
        }
    }

    protected String getEstado(){
        return "Estado: " + this.estado;
    }

    protected  void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;  
    }    
}

class Item{
    private String name;
    private double precio;
    private int cantidad;

    public Item(String name, int cantidad, double precio) {
        this.name = name;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    protected void setPrecio(double precio){
        this.precio = precio;
    }

    protected double  getPrecio() {
        return precio;
    }

    protected int getCantidad(){
        return cantidad;
    }
}

public class Main2 {
    public static void main(String[] args) {
        List<Item> items = List.of(new Item("Laptop", 2, 1000));
        Pedido pedido = new Pedido(items,"Okay");

        System.out.println("\n");
        System.out.println(pedido.getEstado());
        System.out.println("Total: " + pedido.calcularTotal());
        pedido.aplicarDescuento(0.5);
        System.out.println("\n");
        pedido.cambiarEstado("Con Descuento del 0.5");
        System.out.println(pedido.getEstado());
        System.out.println("Total: " + pedido.calcularTotal());
        System.out.println("\n");
    }
}


