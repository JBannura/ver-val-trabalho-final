package grupo11.casosDeUso.Repositorios;

import java.util.List;

import grupo11.entidades.Bairro;

public interface RepositorioBairros {
    Bairro recuperaPorNome(String nomeBairro);
    List<Bairro> recuperaListaBairros();
}