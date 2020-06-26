package grupo11.entidades.geometria;

// Teste
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TesteArea {
    
    @Test
    public void testaPontoCentral(){
        
        Ponto expected = new Ponto(2,2);

        Area a = new Area(new Ponto(0, 4), new Ponto(4, 0));
        Ponto actual = a.pontoCentral();

        Assertions.assertEquals(expected.getX(), actual.getX());
        Assertions.assertEquals(expected.getY(), actual.getY());
    }

    @Test
    public void testaClassifica_TODAFORA(){

        Area a = new Area(new Ponto(0, 4), new Ponto(4, 0));
        Reta r = new Reta(new Ponto(0, 5), new Ponto(4, 5));
        
        SituacaoReta expected = SituacaoReta.TODA_FORA;
        SituacaoReta actual = a.classifica(r);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testaClassifica_TODADENTRO(){

        Area a = new Area(new Ponto(0, 4), new Ponto(4, 0));
        Reta r = new Reta(new Ponto(1, 3), new Ponto(3, 3));
        
        SituacaoReta expected = SituacaoReta.TODA_DENTRO;
        SituacaoReta actual = a.classifica(r);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testaClassifica_INTERSECTA(){

        Area a = new Area(new Ponto(0, 4), new Ponto(4, 0));
        Reta r = new Reta(new Ponto(1, 3), new Ponto(5, 3));
        
        SituacaoReta expected = SituacaoReta.INTERSECTA;
        SituacaoReta actual = a.classifica(r);

        Assertions.assertEquals(expected, actual);
    }
}