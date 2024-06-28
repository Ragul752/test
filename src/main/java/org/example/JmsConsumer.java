package org.example;
hii



import jakarta.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

    public class JmsConsumer {

        public void consume() throws JMSException {

            String brokerURL = "tcp://localhost:61616";

            String queueName = "TEST_QUEUE";

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);

            Connection connection = connectionFactory.createConnection();

            connection.start();

            Session session = connection.createSession();

            Destination destination = session.createQueue(queueName);

            MessageConsumer messageConsumer = session.createConsumer(destination);

            Message message = messageConsumer.receive(1000);

            TextMessage textMessage = null;

            if (message instanceof TextMessage) {

                textMessage = (TextMessage) message;

            }

            if (message instanceof ObjectMessage) {

                ObjectMessage message1 = (ObjectMessage) message;

            }

            try {

                String text = textMessage.getText();

                System.out.println(text);

            } catch (NullPointerException e) {


                session.close();

                connection.close();


            }

        }

    }

