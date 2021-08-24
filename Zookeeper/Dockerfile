FROM docker.io/centos/systemd:latest

RUN yum install -y https://cdn.azul.com/zulu/bin/zulu-repo-1.0.0-1.noarch.rpm \
	&& yum install -y zulu11-jdk wget

RUN mkdir -p /itau/var/zookeeper 	

RUN wget -O /itau/apache-zookeeper-3.7.0-bin.tgz "https://downloads.apache.org/zookeeper/zookeeper-3.7.0/apache-zookeeper-3.7.0-bin.tar.gz"

RUN cd /itau \
	&& tar -xzf apache-zookeeper-3.7.0-bin.tgz \
	&& mv /itau/apache-zookeeper-3.7.0-bin /itau/zookeeper \
	&& rm -rf /itau/apache-zookeeper-3.7.0-bin.tgz 

COPY ./zoo.cfg /itau/zookeeper/conf/

COPY ./zookeeper.service /lib/systemd/system/


EXPOSE 2181 2888 3888 8080 7000