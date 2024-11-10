package br.com.ifto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.function.Function;

public class ProcessadorBoletos {

    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Function<String[], Boleto> processarLinhaArquivo;

    public ProcessadorBoletos(Function<String[], Boleto> processarLinhaArquivo) {
        this.processarLinhaArquivo = processarLinhaArquivo;
    }

    public final void processar(URI nomeArquivo) {
        final var listaBoletos = new ArrayList<Boleto>();
        try {
            var listaLinhas = Files.readAllLines(Paths.get(nomeArquivo));
            for (String linha : listaLinhas) {
                final String[] vetor = linha.split(",");
                final var boleto = processarLinhaArquivo.apply(vetor);
                listaBoletos.add(boleto);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        for (Boleto boleto : listaBoletos) {
            System.out.println(boleto);
        }
    }

}
