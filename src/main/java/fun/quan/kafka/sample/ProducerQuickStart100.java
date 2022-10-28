package fun.quan.kafka.sample;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 生产者
 */
public class ProducerQuickStart100 {

    public static void main(String[] args) {
        // kafka配置
        Properties properties = new Properties();
        // kafka连接地址
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"101.42.254.*:9092");
        // 发送失败，失败的重新次数
        properties.put(ProducerConfig.RETRIES_CONFIG,5);
        // 消息key的序列化器
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        // 消息value的序列化器
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        // 生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        // 封装发送的消息
        ProducerRecord<String, String> record = new ProducerRecord<>(
                "kafka-topic", "10010111", "hello kafka");
        // 发送消息
        producer.send(record);
        // 关闭消息通知，必须关闭，否则消息发送不成功
        producer.close();
    }
}
