FROM postgres:12-alpine

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=1234567
ENV POSTGRES_DB=postgres

COPY 00-init.txt /docker-entrypoint-initdb.d/00-init.sh
COPY uri2602/2602.sql /docker-entrypoint-initdb.d/2602.txt
COPY uri2609/2609.sql /docker-entrypoint-initdb.d/2609.txt
COPY uri2611/2611.sql /docker-entrypoint-initdb.d/2611.txt
COPY uri2621/2621.sql /docker-entrypoint-initdb.d/2621.txt
COPY uri2737/2737.sql /docker-entrypoint-initdb.d/2737.txt
COPY uri2990/2990.sql /docker-entrypoint-initdb.d/2990.txt