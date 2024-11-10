import br.com.ifto.LeituraRetornoBancoBrasil;
import br.com.ifto.ProcessadorBoletos;

import java.net.URI;
import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        final var processador = new ProcessadorBoletos(LeituraRetornoBancoBrasil::processarLinhaArquivo);
        URI caminhoArquivo = Principal.class.getResource("banco-brasil-1.csv").toURI();
        System.out.println("Lendo arquivo " + caminhoArquivo + "\n");

        processador.processar(caminhoArquivo);
    }
}
