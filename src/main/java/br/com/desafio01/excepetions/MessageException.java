package br.com.desafio01.excepetions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MessageException extends RuntimeException {

    private final String messageName;
    private final transient Object[] parameters;

    public MessageException(Throwable cause, String messageName) {
        super(cause);
        this.messageName = messageName;
        this.parameters = null;
    }

    public MessageException(Throwable cause, String messageName, Object... parameters) {
        super(cause);
        this.messageName = messageName;
        this.parameters = parameters;
    }
}
