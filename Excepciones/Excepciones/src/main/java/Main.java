import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Checkeadas
/*        System.out.println("\tAntes del error");
        try
        {
            FileInputStream fileInputStream = new FileInputStream("prueba.txt");
            System.out.println("\tDespues del error");
        }
        catch (FileNotFoundException execpcionArchivoNoEncontrado)
        {
            execpcionArchivoNoEncontrado.printStackTrace(System.out);
//            System.out.println(execpcionArchivoNoEncontrado.getMessage());
            System.out.println("\tEn del error");
        }
        finally {
            System.out.println("\tEn el finally");
        }
        System.out.println("\tDespues del catch");*/

//        ArrayList<String> arr = new ArrayList<>();
//        try
//        {
//            System.out.println(arr.get(0));
//        }
//        catch (IndexOutOfBoundsException e)
//        {
//            System.out.println("error");
//        }
//        FileInputStream fls = new FileInputStream("Pepito.txt");
        int valor = 11;
        try {

            if (valor == 5)
            {
                System.out.println("Esta ok");
            }
            else
            {
//            throw new RuntimeException("El numero no es correcto");
                throw new NotFoundException("El numero no es correcto");
            }
        }
        catch (NotFoundException e)
        {
            System.out.println("Error "+e.getStatus()+": "+e.getMessage());
        }
    }
}
