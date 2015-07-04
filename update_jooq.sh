#!/bin/bash

rm -rf src/main/java/co/charbox/domain/data/jooq

java -classpath jooq-3.6.1.jar:jooq-meta-3.6.1.jar:jooq-codegen-3.6.1.jar:mysql-connector-java-5.1.31-bin.jar:. org.jooq.util.GenerationTool charbot-domain-jooq.xml

