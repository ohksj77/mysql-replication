CREATE USER 'replicator'@'%' IDENTIFIED BY '1234';
GRANT REPLICATION SLAVE, REPLICATION CLIENT, RELOAD, FLUSH_TABLES, REPLICATION_SLAVE_ADMIN ON *.* TO 'replicator'@'%';
FLUSH PRIVILEGES;
