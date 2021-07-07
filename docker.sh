#!/bin/sh

# JANAITE 20210706

docker build -t janaite/devsuperior-sqlqueries .

docker rm -f devsup_sqlqueires

docker run -d \
   --name devsup_sqlqueires \
   -p 5432:5432 \
   janaite/devsuperior-sqlqueries