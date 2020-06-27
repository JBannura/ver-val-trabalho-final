package grupo11.entidades;

// Classes
import grupo11.interfaces.Persistencia.RepositorioBairrosImplMem; 
import grupo11.entidades.geometria.Ponto;

// Teste
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteBairro{
    
    RepositorioBairrosImplMem rb = new RepositorioBairrosImplMem();
    
    @Test
    public void testaNovoBairroQuadradoArea(){
        Bairro expected = rb.recuperaPorNome("Petropolis");
        Bairro actual = Bairro.novoBairroQuadrado("Petropolis", new Ponto(0, 12), 4, 10.0);
        
        Assertions.assertEquals(expected.getArea().getPSupEsq().getX(), actual.getArea().getPSupEsq().getX());
        Assertions.assertEquals(expected.getArea().getPSupEsq().getY(), actual.getArea().getPSupEsq().getY());
        Assertions.assertEquals(expected.getArea().getPInfDir().getX(), actual.getArea().getPInfDir().getX());
        Assertions.assertEquals(expected.getArea().getPInfDir().getY(), actual.getArea().getPInfDir().getY());
    }
    

    @Test
    public void testaNovoBairroQuadradoNome(){
        Bairro expected = rb.recuperaPorNome("Petropolis");
        Bairro actual = Bairro.novoBairroQuadrado("Petropolis", new Ponto(0, 12), 4, 10.0);
        
        Assertions.assertEquals(expected.getNome(), actual.getNome());
    }

    @Test
    public void testaNovoBairroQuadradoCustoTransporte(){
        Bairro expected = rb.recuperaPorNome("Petropolis");
        Bairro actual = Bairro.novoBairroQuadrado("Petropolis", new Ponto(0, 12), 4, 10.0);
        
        Assertions.assertEquals(expected.getCustoTransporte(), actual.getCustoTransporte());
    }
    
    @Test
    public void testaNovoBairroRetangularArea(){
        Bairro expected = rb.recuperaPorNome("Ipiranga");
        Bairro actual = Bairro.novoBairroRetangular("Ipiranga", new Ponto(4, 10), 4, 2, 6);

        Assertions.assertEquals(expected.getArea().getPSupEsq().getX(), actual.getArea().getPSupEsq().getX());
        Assertions.assertEquals(expected.getArea().getPSupEsq().getY(), actual.getArea().getPSupEsq().getY());
        Assertions.assertEquals(expected.getArea().getPInfDir().getX(), actual.getArea().getPInfDir().getX());
        Assertions.assertEquals(expected.getArea().getPInfDir().getY(), actual.getArea().getPInfDir().getY());
    }

    @Test
    public void testaNovoBairroRetangularNome(){
        Bairro expected = rb.recuperaPorNome("Ipiranga");
        Bairro actual = Bairro.novoBairroRetangular("Ipiranga", new Ponto(4, 10), 4, 2, 6);

        Assertions.assertEquals(expected.getNome(), actual.getNome());
    }

    @Test
    public void testaNovoBairroRetangularCustoTransporte(){
        Bairro expected = rb.recuperaPorNome("Ipiranga");
        Bairro actual = Bairro.novoBairroRetangular("Ipiranga", new Ponto(4, 10), 4, 2, 6);

        Assertions.assertEquals(expected.getCustoTransporte(), actual.getCustoTransporte());
    }
}