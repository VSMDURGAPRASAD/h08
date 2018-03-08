package com.spnotes.kafka.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

/**
 * Created by sunilpatil on 12/28/15.
 */
public class Producer {
    private static Scanner in;
    private static int a;
    public static void main(String[] argv)throws Exception {
        if (argv.length != 1) {
            System.err.println("Please specify 1 parameters ");
            System.exit(-1);
        }
        String topicName = argv[0];
        in = new Scanner(System.in);
        // System.out.println("Enter message(type exit to quit)");

        //Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);
//        Random random = new Random();
            a=0;
            System.out.println("THOUGHT OF THE DAY!!");
            System.out.println("=====================================");
            System.out.println("Enter a number between 1 and 6: ");
            a = in.nextInt();
           
            String[] sentences = new String[] {
                "A good laugh and a long sleep are the best cures in the doctor's book. --Irish Proverb",
                "Never give in, never! Be it concerning large things or small things, never, never, never! -- Winston Churchill",
                "When you stretch the truth, watch out for the snapback. -- Bill Copeland",
                "It is not what you say, or wish, or hope or intend, it is only what you do that counts. -- Brian Tracy",
                "A desire to investigate the unknown is the starting point for every great undertaking in history. Your adventurous journey to genius requires a direction too. ... curiosity is how you'll discover it. And be open to directions you've never considered before. Paths of greatness aren't usually obvious. -- Sean Patrick",
                "Joy can be real only if people look upon their lives as a service and have a definite object in life outside themselves and their personal happiness. --Leo Tolstoy",
            };
//        String line = in.nextLine();
//        for(int i = 0; i < 20; i++) {
            // Pick a sentence at random
            //String s = sentences[random.nextInt(sentences.length)];
            // Send the sentence to the test topic

            String s = "THOUGHT OF THE DAY!!\n"+"=====================================\n"+ sentences[a-1];
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, s);
            producer.send(rec);
            s = in.nextLine();
//        }
        in.close();
        producer.close();
    }
}
