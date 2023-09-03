package com.rafael.pizzeria.service.impl;

import com.rafael.pizzeria.service.IConsultaMetodoPagoService;
import com.rafael.pizzeria.utils.ConsultaTipoEnum;
import com.rafael.pizzeria.utils.ListaObjetosDTO;
import com.rafael.pizzeria.utils.enums.PayMethodEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaMetodoPagoService implements IConsultaMetodoPagoService {
    @Override
    public List<ListaObjetosDTO> consultarMetodosPago(){
        return ConsultaTipoEnum.consultarTipoEnum(PayMethodEnum.class);
    }
}
