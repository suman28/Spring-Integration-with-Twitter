package com.twitter.SpringIntegration;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;

public class TwitterOutbound {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("/twitter-outbound.xml", TwitterOutbound.class);

		MessageChannel input = context.getBean("twitterOutbound", MessageChannel.class);

		Message<String> message = new GenericMessage<String>(Calendar.getInstance().getTime()+" Hello Tweeps");

		input.send(message);
	}
}
