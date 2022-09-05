public class Perecedero extends Producto{
    private int DiasPorCaducar;

    public int getDiasPorCaducar() {
        return DiasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        DiasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        DiasPorCaducar = diasPorCaducar;
    }

    public double calcular(int cantidadDeProductos)
    {
        double valorFinal;
        double precio = this.getPrecio();
        valorFinal = precio * cantidadDeProductos;
        switch (getDiasPorCaducar())
        {
            case 1:
                valorFinal/=4;
                break;
            case 2:
                valorFinal/=3;
                break;
            case 3:
                valorFinal/=2;
                break;
            default:
                break;
        }


        return valorFinal;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "DiasPorCaducar=" + DiasPorCaducar +
                '}';
    }
}
