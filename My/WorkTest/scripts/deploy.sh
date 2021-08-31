
#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
    target/Work-0.0.1-SNAPSHOT.jar \
    staravojt.v.a@194.195.241.62:/home/staravojt.v.a/

echo 'Restart server...'

ssh -tt -i ~/.ssh/id_rsa staravojt.v.a@194.195.241.62 << EOF
pgrep java | xargs kill -9
nohup java -jar Work-0.0.1-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'



