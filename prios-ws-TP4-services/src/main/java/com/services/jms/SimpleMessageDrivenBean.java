package com.services.jms;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Simle message driven bean.
 */
@MessageDriven(mappedName = "jms/SimpleQueue")
public class SimpleMessageDrivenBean implements MessageListener {

	/**
	 * Default constructor.
	 */
	public SimpleMessageDrivenBean() {
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		try {
			System.out.println("Got message: "
					+ ((TextMessage) message).getText() + " @"
					+ System.currentTimeMillis());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
