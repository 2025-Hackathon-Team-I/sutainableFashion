#!/bin/bash

# JAR 경로 전체를 정확히 탐색
BUILD_JAR=$(find /home/ubuntu/app -name "*.jar" | head -n 1)

# 에러 처리: jar 파일 없을 경우 중단
if [ -z "$BUILD_JAR" ]; then
  echo ">>> JAR 파일을 찾을 수 없습니다." >> /home/ubuntu/deploy.log
  exit 1
fi

# 경로 및 파일명 분리
JAR_NAME=$(basename "$BUILD_JAR")
DEPLOY_PATH=/home/ubuntu/app/

echo ">>> build 파일명: $JAR_NAME" >> /home/ubuntu/deploy.log

# 기존 프로세스 종료
echo ">>> 현재 실행중인 애플리케이션 종료" >> /home/ubuntu/deploy.log
sudo ps -ef | grep java | grep -v grep | awk '{print $2}' | xargs -r kill -15

# 배포 및 실행
echo ">>> $JAR_NAME 실행 시작" >> /home/ubuntu/deploy.log
nohup java -jar "$BUILD_JAR" >> /home/ubuntu/deploy.log 2>> /home/ubuntu/deploy_err.log &
