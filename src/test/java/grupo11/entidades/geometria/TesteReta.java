package grupo11.entidades.geometria;

// Classes
import grupo11.entidades.geometria.Reta;
import grupo11.entidades.geometria.Ponto;

// Teste
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteReta {

    @Test
    public void testaTamanho(){
        Ponto a = new Ponto(0, 0);
        Ponto b = new Ponto(4, 3);

        Reta actual = new Reta(a, b);
        double expected = 5;

        Assertions.assertEquals(expected, actual.tamanho());

    }

}