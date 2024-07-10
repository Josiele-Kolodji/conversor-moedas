package apresentacao;

import excecoes.OpcaoInvalidaException;

import java.util.Map;
import java.util.Scanner;

public class Menu {

    public void boasVindas() {
        String boasVindas = """
                \tBem vindo(a) ao nosso conversor de moedas!
                \tEssas são nossas opções de conversão.""";
        System.out.println(boasVindas);
    }

    public String escolheMoedaReferencia(Scanner leitura) {
        String titulo = "Escolha a moeda de referência";
        System.out.print(apresentaMoedas(titulo));
        int opcaoEscolhida = leitura.nextInt();
        validaOpcaoEscolhida(opcaoEscolhida);
        return getTipoMoeda(opcaoEscolhida);
    }

    public String escolheMoedaAConverter(Scanner leitura) {
        String titulo = "Escolha a moeda que deseja converter";
        System.out.print(apresentaMoedas(titulo));
        int opcaoEscolhida = leitura.nextInt();
        validaOpcaoEscolhida(opcaoEscolhida);
        return getTipoMoeda(opcaoEscolhida);
    }

    public void apresentaCotacao(String tipoMoeda, double valor) {
        String apresentacao = """
                \t----------------------------------
                \t| O valor convertido é: %s %5.2f |
                \t----------------------------------""".formatted(getSimbolo(tipoMoeda), valor);
        System.out.println(apresentacao);
    }

    public boolean menuEscolhaContinuacao(Scanner leitura) {
        System.out.print("\tPara encerrar digite 0 ou 9 para continuar: ");
        return leitura.nextInt() != 0;
    }

    private String apresentaMoedas(String titulo) {
        return """
                \t*********************************
                \t| %s                            |
                \t| 1 - REAL                      |
                \t| 2 - DÓLAR                     |
                \t| 3 - EURO                      |
                \t| 4 - IENE                      |
                \t| 5 - LIBRA ESTERLINA           |
                \t| 6 - YUAN                      |
                \t*********************************
                """.formatted(titulo);
    }

    private String getTipoMoeda(int tipoMoeda) {
        Map<Integer, String> tiposMoeda = Map
                .of(1, "BRL",
                        2, "USD",
                        3, "EUR",
                        4, "JPY",
                        5, "GBP",
                        6, "CNY");

        return tiposMoeda.get(tipoMoeda);
    }

    private String getSimbolo(String tipoMoeda) {
        Map<String, String> simbolos = Map
                .of("BRL", "R$",
                        "USD", "$",
                        "EUR", "€",
                        "JPY", "¥",
                        "GBP", "£",
                        "CNY", "¥");

        return simbolos.get(tipoMoeda);
    }

    private void validaOpcaoEscolhida(int opcaoMoeda) {
        if (opcaoMoeda < 1 || opcaoMoeda > 6) {
            throw new OpcaoInvalidaException("\tOpção Inválida! Tente novamente!");
        }
    }

}
