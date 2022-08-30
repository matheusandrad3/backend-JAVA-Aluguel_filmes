package br.com.desafio01.excepetions;

public class CadastroLocacaoException extends MessageException{

    public CadastroLocacaoException (String message, Object... parameters){
        super(message, parameters);
    }
}
