package excecoes;

public class OpcaoInvalidaException extends RuntimeException {

    private final String mensagem;

    public OpcaoInvalidaException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
