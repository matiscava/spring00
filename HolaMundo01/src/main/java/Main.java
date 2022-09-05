import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hola Mundo");

        //Tamagochi osito = new Tamagochi();
        //Tamagochi milanesa = new Tamagochi("contenta",0);
        //System.out.println("Nivel de milanesa: "+milanesa.getNivel());

        //milanesa.jugar();

        //System.out.println("Nivel de milanesa: "+milanesa.getNivel());

        ArrayList<Tamagochi> mascotas = new ArrayList<>();
        mascotas.add(new Tamagochi("hambrienta",0));
        mascotas.add(new Tamagochi("contenta",0));
        mascotas.add(new Tamagochi("enojada",0));

        // Como recorrer un Arraylist con foreach
        for (Tamagochi bicho: mascotas)
        {
            bicho.jugar();
        }
        // Como recorrer un Arraylist con foreach y lambdas
        mascotas.forEach( osito -> osito.jugar() );
        // Como recorrer un ArrayList con for estandar
        for ( int i = 0 ; i < mascotas.size() ; i++ )
        {
            mascotas.get(i).jugar();
        }
        //Como recorrerlo con Stream
        mascotas.stream().peek(osito-> osito.jugar());

    }
}
