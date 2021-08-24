package br.com.itau.caseitau;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var producer = new KafkaProducer<String, String>(properties());
        String value = "";
        for(String  str : args){
            value += str + " " ;
        }
        var record = new ProducerRecord<>("test-topic", value, value);
        producer.send(record, (data, ex)->{
            if(ex != null){
                ex.printStackTrace();
                return;
            }
            System.out.println("Mensagem Enviada");
            System.out.println("Topico " + data.topic());
            System.out.println("Particao " + data.partition());
            System.out.println("Offset " +  data.offset());
            System.out.println("Timestamp" + data.timestamp());
        }).get();
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"kafka:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }
}
