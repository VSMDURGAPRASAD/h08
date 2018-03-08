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
    public static void main(String[] argv)throws Exception {
        if (argv.length != 1) {
            System.err.println("Please specify 1 parameters ");
            System.exit(-1);
        }
        String topicName = argv[0];
        in = new Scanner(System.in);
        

        //Configure the Producer
        Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);
        System.out.println("Enter a single lowercase letter between a and m to convert to English Phonetic");

        String line = in.nextLine();
        String codeword = "";
        while(!line.equals("exit")) {
            
            if (line.equals("a")){
                codeword = "alpha";
            }
            if (line.equals("b")){
                codeword = "bravo";
            }
            if (line.equals("c")){
                codeword = "charlie";
            }
            if (line.equals("d")){
                codeword = "delta";
            }
            if (line.equals("e")){
                codeword = "echo";
            }
            if (line.equals("f")){
                codeword = "foxtrot";
            }
            if (line.equals("g")){
                codeword = "golf";
            }
            if (line.equals("h")){
                codeword = "hotel";
            }
            if (line.equals("i")){
                codeword = "india";
            }
            if (line.equals("j")){
                codeword = "juliet";
            }
            if (line.equals("k")){
                codeword = "kilo";
            }
            if (line.equals("l")){
                codeword = "lima";
            }
            if (line.equals("m")){
                codeword = "motel";
            }
            if (line.equals("n")){
                codeword = "november";
            }
            if (line.equals("o")){
                codeword = "oscar";
            }
            if (line.equals("p")){
                codeword = "papa";
            }
            if (line.equals("q")){
                codeword = "quebec";
            }
            if (line.equals("r")){
                codeword = "romeo";
            }
            if (line.equals("s")){
                codeword = "sierra";
            }
            if (line.equals("t")){
                codeword = "tango";
            }
            if (line.equals("u")){
                codeword = "uniform";
            }
            if (line.equals("v")){
                codeword = "victor";
            }
            if (line.equals("w")){
                codeword = "whiskey";
            }
            if (line.equals("x")){
                codeword = "xray";
            }
            if (line.equals("y")){
                codeword = "yankee";
            }
            if (line.equals("z")){
                codeword = "zulu";
            }
            
            //TODO: Make sure to use the ProducerRecord constructor that does not take parition Id
            ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName,codeword);
            producer.send(rec);
           
            line = in.nextLine();
        }
        in.close();
        producer.close();
    }
}
