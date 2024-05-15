FROM mysql:8.0
COPY ./init.sql /docker-entrypoint-initdb.d/
ADD ./my.cnf /etc/mysql/my.cnf
