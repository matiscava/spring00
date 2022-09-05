import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Distribuidora {
    public static void main(String[] args) {
        AtomicReference<Double> compra= new AtomicReference<>((double) 0);
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Leche entera",300,2));
        productos.add(new Perecedero("Yogurt de Vainilla",350,1));
        productos.add(new Perecedero("Yogurt de Banan",370,3));
        productos.add(new Perecedero("Queso Crema",750,2));
        productos.add(new Perecedero("Queso Dambo",910,3));
        productos.add(new NoPerecedero("Spaguetti",170,"Pastas"));
        productos.add(new NoPerecedero("Penne Rigate",190,"Pastas"));
        productos.add(new NoPerecedero("Lata arbejas",270,"Conserva"));
        productos.add(new NoPerecedero("lata Jardinera",240,"Conserva"));
        productos.add(new NoPerecedero("Lata Porotos",280,"Conserva"));

        productos.forEach( producto -> {
            double calculo = producto.calcular( 5 );
            compra.updateAndGet(v -> new Double((double) (v + calculo)));
        });
        System.out.println("Valor final de la compra : "+compra);

    }
}
