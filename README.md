# 工程简介
生产者：生产消息

消费者：消费消息
# 延伸阅读
### 3)kafka安装配置

Kafka对于zookeeper是强依赖，保存kafka相关的节点数据，所以安装Kafka之前必须先安装zookeeper

- Docker安装zookeeper(先删再加)

创建容器

```shell
docker rm -f zookeeper

docker run -d --name zookeeper --restart=always -p 2181:2181 zookeeper:3.4.14
```

- Docker安装kafka

创建容器

```shell
docker rm -f kafka


docker run -d --name kafka \
--env KAFKA_ADVERTISED_HOST_NAME=101.42.254.157 \
--env KAFKA_ZOOKEEPER_CONNECT=101.42.254.*:2181 \
--env KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://101.42.254.*:9092 \
--env KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 \
--env KAFKA_HEAP_OPTS="-Xmx256M -Xms256M" \
--restart=always \
--net=host wurstmeister/kafka:2.12-2.3.1
```

kafka名词解释
- producer：发布消息的对象称之为主题生产者（Kafka topic producer）
- topic：Kafka将消息分门别类，每一类的消息称之为一个主题（Topic）
- consumer：订阅消息并处理发布的消息的对象称之为主题消费者（consumers）
- broker：已发布的消息保存在一组服务器中，称之为Kafka集群。集群中的每一个服务器都是一个代理（Broker）。 消费者可以订阅一个或多个主题（topic），并从Broker拉数据，从而消费这些已发布的消息

- 生产者发送消息，多个消费者只能有一个消费者接收到消息

- 生产者发送消息，多个消费者都可以接收到消息
