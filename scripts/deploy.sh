#!/bin/bash

DEPLOY_DIR="/home/ubuntu/app"
DEPLOY_LOG="/home/ubuntu/deploy.log"
ERR_LOG="/home/ubuntu/deploy_err.log"

echo ">>> 배포 시작: $(date)" >> $DEPLOY_LOG

BUILD_JAR=$(find $DEPLOY_DIR -name "*.jar" | head -n 1)
JAR_NAME=$(basename $BUILD_JAR)
echo ">>> 빌드 파일명: $JAR_NAME" >> $DEPLOY_LOG

echo ">>> 기존 애플리케이션 종료" >> $DEPLOY_LOG
sudo ps -ef | grep java | grep -v grep | awk '{print $2}' | xargs -r kill -15

echo ">>> 새 애플리케이션 실행" >> $DEPLOY_LOG
nohup java -jar $BUILD_JAR >> $DEPLOY_LOG 2>> $ERR_LOG &

echo ">>> 배포 완료: $(date)" >> $DEPLOY_LOG