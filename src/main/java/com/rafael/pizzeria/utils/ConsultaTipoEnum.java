package com.rafael.pizzeria.utils;

import java.util.ArrayList;
import java.util.List;

public class ConsultaTipoEnum {
    public static <E extends Enum<E> &ICodMessage> List<ListaObjetosDTO> consultarTipoEnum(Class<E> tipoEnum){
        List<ListaObjetosDTO> listaObjetosDTOS = new ArrayList<>();
        for(E enumType : tipoEnum.getEnumConstants()){
            ListaObjetosDTO objetosDTO = new ListaObjetosDTO();
            objetosDTO.setExitoso(true);
            objetosDTO.setValor(enumType.name());
            objetosDTO.setEtiqueta(enumType.getMessageCod());
            listaObjetosDTOS.add(objetosDTO);
        }
        return listaObjetosDTOS;
    }
}
