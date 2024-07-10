import apis.ExchangerateApi;
import apresentacao.Menu;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Menu menu = new Menu();
        ExchangerateApi api = new ExchangerateApi();
        Scanner teclado = new Scanner(System.in);
        boolean finaliza = true;

        menu.boasVindas();

        while (finaliza) {
            String opcaoMoedaReferencia = menu.escolheMoedaReferencia(teclado);
            String opcaoMoedaAConverter = menu.escolheMoedaAConverter(teclado);

            Double cotacao = api.getCotacao(opcaoMoedaReferencia, opcaoMoedaAConverter);

            menu.apresentaCotacao(opcaoMoedaAConverter, cotacao);
            finaliza = menu.menuEscolhaContinuacao(teclado);
        }
    }

}