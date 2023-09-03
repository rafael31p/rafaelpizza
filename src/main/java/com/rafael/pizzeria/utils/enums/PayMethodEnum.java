package com.rafael.pizzeria.utils.enums;

import com.rafael.pizzeria.utils.ICodMessage;

public enum PayMethodEnum implements ICodMessage {
    E("EFECTIVO"), T("TARJETA DEBITO/CREDITO"), N("NEQUI"), D("DAVIPLATA");
    private String messageCod;

    PayMethodEnum(String messageCod) {
        this.messageCod = messageCod;
    }

    public String getMessageCod() {
        return messageCod;
    }
}
