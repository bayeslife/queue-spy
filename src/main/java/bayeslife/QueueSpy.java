package bayeslife;

import org.apache.activemq.ActiveMQConnectionFactory;


import javax.jms.*;

public class QueueSpy {

    public static void main(String[] args) throws Exception {
        new QueueSpy();
    }

    public QueueSpy() throws Exception {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin","admin","failover:(tcp://localhost:61616)");

        // Create a Connection
        Connection connection = connectionFactory.createConnection();

        // Create a Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create the destination (Topic or Queue)
        //Topic destination = session.createTopic("TEST.TOPIC");
        Queue destination = session.createQueue("TEST.QUEUE");

        // Create a MessageConsumer from the Session to the Topic or Queue
        MessageConsumer consumer = session.createConsumer(destination);

        MessageListener listener = new ListenerToConsole();
        consumer.setMessageListener(listener);
        connection.start();
    }

}
