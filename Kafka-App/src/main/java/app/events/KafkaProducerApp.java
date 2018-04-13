package app.events;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String, String> kp = new KafkaProducer<String, String>(props);
		
		ProducerRecord<String, String> myMessage = new ProducerRecord<String, String>("stream_pipe_replicated","Dummy Next Message!!");
		
		kp.send(myMessage);
		kp.close();
	}

}
