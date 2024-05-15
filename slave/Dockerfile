FROM mysql:8.0
ADD ./my.cnf /etc/mysql/my.cnf
COPY ./init.sql /docker-entrypoint-initdb.d/
COPY ./entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh
ENTRYPOINT ["sh", "/usr/local/bin/entrypoint.sh"]
