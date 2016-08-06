package bayeslife;

import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 */
public class ListenerToConsole implements MessageListener {

    public void onMessage(Message msg) {
        try {
            ActiveMQTextMessage msg1 = (ActiveMQTextMessage) msg;
            System.out.println();
            System.out.println(msg1.getDestination().toString());
            System.out.println(msg1.getText());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}


