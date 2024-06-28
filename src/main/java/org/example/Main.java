package org.example;

import jakarta.jms.JMSException;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws JMSException, SQLException, JMSException {
    JmsProducer jmsProducer = new JmsProducer();
    jmsProducer.produce();
    JmsConsumer jmsConsumer = new JmsConsumer();
    jmsConsumer.consume();
    }
}