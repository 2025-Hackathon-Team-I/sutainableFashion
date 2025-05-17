#!/bin/bash

DEPLOY_LOG="/home/ubuntu/deploy.log"
ERR_LOG="/home/ubuntu/deploy_err.log"
DEPLOY_DIR="/home/ubuntu/app"

echo "" >> $DEPLOY_LOG
echo ">>> 배포 시작: $(date)" >> $DEPLOY_LOG

# JAR 탐색
BUILD_JAR=$(find $DEPLOY_DIR -name "*.jar" | head -n 1)

if [ -z "$BUILD_JAR" ]; then
  echo ">>> JAR 파일을 찾을 수 없습니다." >> $DEPLOY_LOG
  exit 1
fi

JAR_NAME=$(basename $BUILD_JAR)
echo ">>> 빌드 파일명: $JAR_NAME" >> $DEPLOY_LOG

# 기존 애플리케이션 종료
echo ">>> 실행 중인 애플리케이션 종료 시도..." >> $DEPLOY_LOG
sudo ps -ef | grep java | grep -v grep | awk '{print $2}' | xargs -r kill -15

sleep 3

# 애플리케이션 실행
echo ">>> 애플리케이션 실행 시작" >> $DEPLOY_LOG
nohup java -jar $BUILD_JAR --spring.profiles.active=prod >> $DEPLOY_LOG 2>> $ERR_LOG &

echo ">>> 배포 완료: $(date)" >> $DEPLOY_LOG