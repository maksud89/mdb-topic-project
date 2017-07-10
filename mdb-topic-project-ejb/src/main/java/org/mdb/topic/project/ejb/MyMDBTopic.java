package org.mdb.topic.project.ejb;

import java.util.logging.Logger;

import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;
import javax.jms.*;


@MessageDriven(name = "HelloWorldTopicMDB", activationConfig = {
@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
@ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/HELLOWORLDMDBTopic"),
@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class MyMDBTopic implements MessageListener {
	 private final static Logger LOGGER = Logger.getLogger(MyMDBTopic.class.toString());

	    /**
	     * @see MessageListener#onMessage(Message)
	     */
	    public void onMessage(Message rcvMessage) {
	        TextMessage msg = null;
	        try {
	            if (rcvMessage instanceof TextMessage) {
	                msg = (TextMessage) rcvMessage;
	                LOGGER.info("MyMDB Received Message from topic: " + msg.getText());
	            } else {
	                LOGGER.warning("Message of wrong type: " + rcvMessage.getClass().getName());
	            }
	        } catch (JMSException e) {
	            throw new RuntimeException(e);
	        }
	    }
	

}