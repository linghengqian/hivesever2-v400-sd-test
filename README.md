## hivesever2-v400-sd-test

- For https://github.com/dbeaver/dbeaver/issues/22777 .

- Verified under Ubuntu 22.04.4 and `SDKMAN!`.

```shell
sdk install java 22.0.2-graalce
sdk use java 22.0.2-graalce

git clone git@github.com:linghengqian/hive-embedded-mode-test.git
cd ./hive-embedded-mode-test/
docker run -d -p 10000:10000 -p 10002:10002 --env SERVICE_NAME=hiveserver2 --name hive4 apache/hive:4.0.0
./mvnw clean test
docker rm --force hive4
```

- Log as follows.

```shell
$ ./mvnw clean test

```
