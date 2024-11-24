package br.com.ifto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeituraRetornoBancoBradesco {

    public static Boleto processarLinhaArquivo(String[] vetor) {
        var boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(String.valueOf((vetor[1])));
        boleto.setAgencia(String.valueOf((vetor[2])));
        boleto.setContaBancaria(String.valueOf((vetor[3])));
        boleto.setDataVencimento(LocalDate.parse(vetor[4], ProcessadorBoletos.FORMATO_DATA));
        boleto.setDataPagamento(LocalDateTime.parse(vetor[5], ProcessadorBoletos.FORMATO_DATA_HORA));
        boleto.setCpfCliente(vetor[6]);
        boleto.setValor(Double.parseDouble(vetor[7]));
        boleto.setJuros(Double.parseDouble(vetor[8]));
        boleto.setMulta(Double.parseDouble(vetor[9]));
        return boleto;
    }

}
