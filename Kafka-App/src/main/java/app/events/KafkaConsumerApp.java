package app.events;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("group.id", "test");
		
		KafkaConsumer<String, String> kc = new KafkaConsumer<String, String>(props);
		
		ArrayList<String> topics = new ArrayList<String>();
		topics.add("stream_pipe_replicated");
		
		kc.subscribe(topics);
		
		while(true)
		{
			ConsumerRecords<String, String> myMessages = kc.poll(100);
			for (ConsumerRecord<String, String> consumerRecord : myMessages)
			{
				System.out.println("Received Message : "+consumerRecord.value());
			}
		}
		
	
		//kc.close();
	}

}
