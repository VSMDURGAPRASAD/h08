package edu.nwmissouri.pochampally.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;


public class CustomProducer {
    private static Scanner in;
	private static String a,b,c;
    public static void main(String[] argv)throws Exception {
        if (argv.length != 1) {
            System.err.println("Please specify 1 parameters ");
            System.exit(-1);
        }
        String topicName = argv[0];
        in = new Scanner(System.in);
        System.out.println("Addition");
		System.out.println("=======================");

        //Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);
        //System.out.println("Enter value of A: ");
		a = "this"+ "is";
        //in.nextLine();
		//System.out.println("Enter value of B: ");
		b = "abhilash";
        //in.nextLine();
		c = a+b;
        int i=1;
        while ( i<10){

             ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName,c);
            producer.send(rec);
        i++;
        }
		// System.out.println(a+b);

        while(!c.equals("exit")) {
            //TODO: Make sure to use the ProducerRecord constructor that does not take parition Id
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName,c);
            producer.send(rec);
            c = in.nextLine();
        }
        in.close();
        producer.close();
    }
}
