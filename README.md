## hivesever2-v400-sd-test

- For https://github.com/dbeaver/dbeaver/issues/22777 .

- Verified under Ubuntu 22.04.4 and `SDKMAN!`.
  Avoid using `testcontainers-java` due to the involvement of operations in dbeaver.

```shell
sdk install java 22.0.2-graalce
sdk use java 22.0.2-graalce

git clone git@github.com:linghengqian/hive-embedded-mode-test.git
cd ./hive-embedded-mode-test/
docker compose -f ./docker-compose-lingh.yml pull
docker compose -f ./docker-compose-lingh.yml up -d
./mvnw clean test
docker compose -f ./docker-compose-lingh.yml down
```

- Log as follows.

```shell
$ ./mvnw clean test

```
