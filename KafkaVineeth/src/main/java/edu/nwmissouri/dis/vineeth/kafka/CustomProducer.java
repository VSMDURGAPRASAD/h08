package edu.nwmissouri.dis.vineeth.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

/**
 * Custom Producer using Kafka for messaging. 
 * Reads properties from the run.properties file in 
 * src/main/resources.
 */
public class CustomProducer {
  private static Scanner in;
    public static void main(String[] argv)throws Exception {
        if (argv.length != 1) {
            System.err.println("Please specify 1 parameters ");
            System.exit(-1);
        }
        String topicName = argv[0];
        in = new Scanner(System.in);
        System.out.println("Enter message(type exit to quit)");

        //Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);
        Random r1= new Random();
        for(int i=0; i<21; i++) {
            //TODO: Make sure to use the ProducerRecord constructor that does not take parition Id
            int num = r1.nextInt();
            System.out.println("Generated Number : "+ num);
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName,Integer.toString(num));
            producer.send(rec);
        }
        in.close();
        producer.close();
    }
}
