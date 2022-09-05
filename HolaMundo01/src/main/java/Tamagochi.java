import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Tamagochi
{
    private String estado;
    private int nivel;


    public void comer ()
    {
        switch (estado)
        {
            case "hambrienta":
                estado = "contenta";
                System.out.println("La Mascota está contenta.");
                break;
            case "contenta":
                nivel += 1;
                break;
            case "aburrida":
                estado = "contenta";
                break;
            default:
                break;
        }
    }

    public void jugar ()
    {
        if(puedeJugar())
        {
            switch (estado)
            {
                case "contenta":
                    nivel +=2;
                    break;
                case "aburrida":
                    estado = "contenta";
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public String toString()
    {
        return "Tamagochi{" +
                "estado=" + estado +
                ", nivel=" + nivel +
                '}';
    }

    private boolean puedeJugar()
    {
        if(estado.equals("hambrienta"))return false;
        return true;ca
    }

}
