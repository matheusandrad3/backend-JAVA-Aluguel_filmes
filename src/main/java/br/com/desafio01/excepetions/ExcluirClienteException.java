package br.com.desafio01.excepetions;

public class ExcluirClienteException extends MessageException {

    public ExcluirClienteException (String message, Object... parameters){
        super(message, parameters);
    }
}
