package com.rafael.pizzeria.model.audit;

import com.rafael.pizzeria.model.entity.Pizza;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AuditPizzaListener {
    private Logger logger = Logger.getLogger(AuditPizzaListener.class.getName());
    private Pizza currentValue;
    @PostLoad
    public void postLoad(Pizza pizza){
        logger.log(Level.INFO, "Post load");
        this.currentValue = SerializationUtils.clone(pizza);
    }
    @PostPersist
    @PostUpdate
    public void onPostPersist(Pizza pizza){
        logger.log(Level.INFO, "Post persist or update");
        logger.log(Level.INFO, "Old value: {0}", this.currentValue.toString());
        logger.log(Level.INFO, "New value: {0}", pizza.toString());
    }
    @PreRemove
    public void onPreDelect(Pizza pizza){
        logger.log(Level.INFO, pizza.toString());
    }
}
