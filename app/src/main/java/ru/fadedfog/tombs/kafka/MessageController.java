package ru.fadedfog.tombs.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MessageController {
	private static MessageController msgController;
	private Properties props;
	private Producer<String, String> producer;
	private final String nameTopics = "Tombs";
	
	private MessageController() {
		props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<String, String>(props);
	}
	
	public static MessageController getInstance() {
		if (msgController == null) {
			msgController = new MessageController();
		}
		return msgController;
	}
	
	public void sendOrder(String msgKey, String msg) {
		ProducerRecord<String, String> producerRecorder = new ProducerRecord<String, String>(nameTopics, msgKey, msgKey + " " + msg);
		producer.send(producerRecorder);
	}
	
}
