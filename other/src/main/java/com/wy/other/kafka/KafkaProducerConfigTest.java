package com.wy.other.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * Created on 2019/7/18.
 * Title: Simple
 * Description:
 * 三种发送方式
 * 1.发送并忘记 ：
 * 把消息发送到服务器，但是并不关心它是否到达。大多数的情况下，消息会正常到达，因为kafka是高可用的，
 * 而且生产者会自动尝试重发。不过使用这种方式有时候也会丢失一些数据。
 * 2.同步发送
 * 我们使用send()方法发送消息，它会返回一个future对象，调用get()方法进行等待，就可以知道消息是否发送成功
 * 3.异步发送
 * 我们调用send()方法，并制定一个回调函数，服务器在返回响应时候调用该函数。
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
@Slf4j
public class KafkaProducerConfigTest {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        //设置生产者内存缓冲区的大小。
        props.put("buffer.memory", 33554432);
        //默认情况，是不会被压缩，参数可以设置为snappy,gzip,lz4，它指定了消息被发送给broker之前使用哪一种压缩算法进行压缩。
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG,"gzip");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //创建生产者
        Producer<String, String> producer = new KafkaProducer<>(props);
        try {
           /* ProducerRecord的泛型表示，主要是key，value的对象
            使用生产者的的send()方法发送ProducerRecord对象。从生产者的架构图里可以看到，消息先被放到缓冲区，然后使用单独的编程发送到服务器端。
            send()方法会返回一个包办RecordMetadata的Future对象，不过因为我们常常忽略返回值，所以无法知道消息是否发送成功。如果不关心发送结果，那么可以使用
            这种发送方式。eg:记录不太重要的日志，或者是实时的GPS信息，而且在生产者发送的时候还是会存在异常情况出现的（序列化异常，缓冲区已满，发送线程中断等）*/
            //todo 1.发送并忘记
            // producer.send(new ProducerRecord<String, String>("my-topic", "hello world+"));


          /*  1.producer.send()方法先返回一个Future对象，然后调用Future的get()方法等待kafka响应。如果服务器返回错误，get()方法会抛出异常。
            如果没有错误，我们会得到一个RecordMetadata的对象，可以用它得到消息的偏移量。
            2.如果在发送数据之前或者在发送过程中发生了任何错误，比如broker返回了一个不允许重发消息的异常或者已经超过了重发的次数，那么就会抛出异常
            在catch中可以做异常的处理，这里只是把日志进行打印。*/
         /*   kafkaProducer一般会发生两种错误。1：可重试错误。这类错误可以通过重发消息来解决。
                                            2.eg:连接错误，可以通过再次建立连接来解决。“无主(no leader)” 错误则可以通过重新为分区选举首领来解决。
            kafkaProducer可以被配成自动重试，如果多次重试后仍无法解决问题,应用程序会收到一个重试异常，另一类错误无法通过重试解决，比如“消息太大异常”。
            对于这类错误，不会进行重试，会直接进行抛出异常。*/
            //todo 2.同步发送
            for (int i = 0; i < 10; i++) {
                RecordMetadata recordMetadata = producer.send(new ProducerRecord<String, String>("my-topic", "hello world+" + i)).get();
                System.out.println(recordMetadata.offset() + "----" + recordMetadata.partition() + "----" + recordMetadata.topic());
            }

            //todo 异步发送
          /*假设消息在应用程序和kafka集群之间来回需要10ms。如果在发送完每个消息后都等待回应，那么发送100个消息需要1秒。但如果只发送消息而不等待回应，那么
            发送100个消息的时间会是少很多。大多数时候，我们并不需要等待响应--尽管kafka会把主题目标、分区信息、和消息的偏移量发送回来，但对于发送端的应用程序来说不是必须的
            不过我们遇到消息发送失败时，是需要抛出异常，用来记录错误日志，或者把消息写进错误消息文件中的，方便以后分析使用。*/
            //todo 为了在异步发送消息的同时能够对异常情况进行处理，生产者提供了回调支持。
            //为了支持回调，需要实现Callback接口的onCompletion方法。
            //在发送消息出去的时候，要传入一个回调对象用以实现回调方法
          /*  producer.send(new ProducerRecord<String, String>("my-topic", "hello world+"), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (null == exception) {
                        log.info("You can print some of the information you need without any exceptions");
                        log.info("这里不出现异常可以打印自己需要的一些信息");
                    } else {
                        log.error("Only the log is printed here, but in real project development you can optimize it according to the company's business scenario");
                        log.error("这里只进行日志的打印，但是在实际的项目开发中可以根据company的业务场景进行优化");
                        exception.printStackTrace();
                    }
                }
            });*/

        } catch (Exception e) {
            log.error("send fail Exception={}:", e);
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
