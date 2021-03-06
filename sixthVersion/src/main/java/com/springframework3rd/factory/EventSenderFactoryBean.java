package com.springframework3rd.factory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class EventSenderFactoryBean implements FactoryBean<EventSender>, InitializingBean {
    private static Logger logger = Logger.getLogger(EventSenderFactoryBean.class);

    public EventSenderFactoryBean() {
        logger.info("Created EventSenderFactoryBean");
    }

    @Override
    public EventSender getObject() {
        logger.info("getObject method of EventSenderFactoryBean invoked");
        return new EventSender();
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Class<?> getObjectType() {
        return EventSender.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet method of EventSenderFactoryBean invoked");
    }
}

