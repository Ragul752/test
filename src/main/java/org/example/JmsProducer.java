package org.example;
hello

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;


import java.sql.SQLException;

public class JmsProducer {
    public void produce() throws JMSException {
        String brokerURL = "tcp://localhost:61616";
        String queueName = "TEST_QUEUE";

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession();

        Destination destination = session.createQueue(queueName);

        MessageProducer messageProducer = session.createProducer(destination);

        String message = "This is a sample message";

        TextMessage textMessage = session.createTextMessage(message);

        messageProducer.send(textMessage);

        session.close();
        connection.close();
    }
    }

