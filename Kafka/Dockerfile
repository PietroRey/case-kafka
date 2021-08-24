FROM docker.io/centos/systemd:latest

RUN yum install -y https://cdn.azul.com/zulu/bin/zulu-repo-1.0.0-1.noarch.rpm \
	&& yum install -y zulu11-jdk wget

RUN mkdir -p /itau/var/kafka 	

RUN wget -O /itau/kafka_2.13-2.7.0.tgz "https://archive.apache.org/dist/kafka/2.7.0/kafka_2.13-2.7.0.tgz" 

RUN cd /itau \
	&& tar -xzf kafka_2.13-2.7.0.tgz \
	&& mv /itau/kafka_2.13-2.7.0 /itau/kafka \
	&& rm -rf /itau/kafka_2.13-2.7.0.tgz

COPY ./server.properties /itau/kafka/config/

COPY ./kafka.service /lib/systemd/system/

COPY ./prom-jmx-config.yml /opt/prom-jmx-config.yml

RUN wget -O /opt/jmx_prometheus_javaagent.jar "https://repo1.maven.org/maven2/io/prometheus/jmx/jmx_prometheus_javaagent/0.12.0/jmx_prometheus_javaagent-0.12.0.jar"

EXPOSE 9092 7071