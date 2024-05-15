#!/bin/bash
# MySQL 서버 시작
docker-entrypoint.sh mysqld &

# MySQL 서버가 준비될 때까지 기다림
while ! mysqladmin ping -h localhost --silent; do
    sleep 1
done

# 슬레이브 설정 스크립트 실행
export MYSQL_PWD='1234'

# Master DB의 IP 주소 및 마스터 상태 정보를 변수로 설정
MASTER_IP=$(getent hosts db_master | awk '{ print $1 }')
MASTER_STATUS=$(mysql -u replicator -h $MASTER_IP -e "SHOW MASTER STATUS;")
MASTER_LOG_FILE=$(echo "$MASTER_STATUS" | awk 'NR==2 {print $1}')
MASTER_LOG_POS=$(echo "$MASTER_STATUS" | awk 'NR==2 {print $2}')

# 슬레이브에서 MySQL 복제 설정
mysql -u replicator -h localhost -P 3306 -e "STOP SLAVE;"
mysql -u replicator -h localhost -P 3306 -e "RESET SLAVE;"
mysql -u replicator -h localhost -P 3306 -e "CHANGE MASTER TO MASTER_HOST='$MASTER_IP', MASTER_USER='replicator', MASTER_PASSWORD='1234', MASTER_LOG_FILE='$MASTER_LOG_FILE', MASTER_LOG_POS=$MASTER_LOG_POS, GET_MASTER_PUBLIC_KEY=1;"
mysql -u replicator -h localhost -P 3306 -e "START SLAVE;"

# 복제 상태 확인
mysql -u replicator -h localhost -P 3306 -e "SHOW SLAVE STATUS\G;"

# MySQL 프로세스가 종료되지 않도록 대기
wait $!
