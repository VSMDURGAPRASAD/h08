package com.spnotes.kafka.simple;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;


public class Consumer {
    private static Scanner in;

    public static void main(String[] argv)throws Exception{

         System.out.println("hey what");
        if (argv.length != 2) {
            System.err.printf("Usage: %s <topicName> <groupId>\n",
                    Consumer.class.getSimpleName());
            System.exit(-1);
        }
        in = new Scanner(System.in);
        String topicName = argv[0];
        System.out.println(topicName);
        String groupId = argv[1];

        ConsumerThread consumerRunnable = new ConsumerThread(topicName,groupId);
        consumerRunnable.start();
        String line = "";
        while (!line.equals("exit")) {
            line = in.next();
            System.out.println(line);

        }
        consumerRunnable.getKafkaConsumer().wakeup();
        System.out.println("Stopping consumer .....");
        consumerRunnable.join();
    }

    private static class ConsumerThread extends Thread{
        private String topicName;
        private String groupId;
        private KafkaConsumer<String,String> kafkaConsumer;

        public ConsumerThread(String topicName, String groupId){
            this.topicName = topicName;
            this.groupId = groupId;
        }
        public void run() {
            Properties configProperties = new Properties();
            configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
            configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
            configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "simple");

            //Figure out where to start processing messages from
            kafkaConsumer = new KafkaConsumer<String, String>(configProperties);
            kafkaConsumer.subscribe(Arrays.asList(topicName));
            //Start processing messages
            try {
                while (true) {
                    ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
                    for (ConsumerRecord<String, String> record : records){
                       // System.out.println(record.value());
                      //  System.out.println(record.value());
                        if(record.value().equals("Avengers")){
                           // record.value()=8.0;
                            System.out.println("The review is:  8.0");

                        }
                        if(record.value().equals("Thor")){
                           // record.value()=8.0;
                            System.out.println("The review is:  9.0");

                        }
                        if(record.value().equals("XMEN")){
                           // record.value()=8.0;
                            System.out.println("The review is:  9.8");

                        }
                        if(record.value().equals("Batman")){
                           // record.value()=8.0;
                            System.out.println("The review is:  8.7");

                        }
                        if(record.value().equals("Superman")){
                           // record.value()=8.0;
                            System.out.println("The review is:  9.6");

                        }
                        if(record.value().equals("Catwoman")){
                           // record.value()=8.0;
                            System.out.println("The review is:  9.8");

                        }
                        if(record.value().equals("XXX")){
                           // record.value()=8.0;
                            System.out.println("The review is:  9.9");

                        }
                        if(record.value().equals("Wind Tunnel")){
                           // record.value()=8.0;
                            System.out.println("The review is:  9.7");

                        }
                        if(record.value().equals("Tinker Bell")){
                           // record.value()=8.0;
                            System.out.println("The review is:  9.8");

                        }
                        if(record.value().equals("Peter Pan")){
                           // record.value()=8.0;
                            System.out.println("The review is:  9.8");

                        }

                    }

                    
                        //System.out.println(record.key());
                }
            }catch(WakeupException ex){
                System.out.println("Exception caught " + ex.getMessage());
            }finally{
                kafkaConsumer.close();
                System.out.println("After closing KafkaConsumer");
            }
        }
        public KafkaConsumer<String,String> getKafkaConsumer(){
           return this.kafkaConsumer;
        }
    }
}