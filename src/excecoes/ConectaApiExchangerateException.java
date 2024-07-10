package excecoes;

public class ConectaApiExchangerateException extends RuntimeException {

    private String mensagem;

    public ConectaApiExchangerateException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }

}
