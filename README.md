## hivesever2-v400-sd-test

- For https://github.com/dbeaver/dbeaver/issues/22777 ,
  https://issues.apache.org/jira/browse/HIVE-28423 and
  https://issues.apache.org/jira/browse/HIVE-28424 .

- Deploy a apache/zookeeper Web UI at `http://localhost:9001/` by executing
  `docker run -d --net host -e HTTP_PORT=9001 --name zoonavigator --restart unless-stopped elkozmon/zoonavigator:1.1.3`
  for easy observation. Use `localhost:2181` to connect Zookeeper Server.

- Verified under Ubuntu 22.04.4 and `SDKMAN!`.
  Avoid using `testcontainers-java` due to the involvement of operations in dbeaver.

```shell
sdk install java 22.0.2-graalce
sdk use java 22.0.2-graalce
git clone git@github.com:linghengqian/hivesever2-v400-sd-test.git
cd ./hivesever2-v400-sd-test/
docker compose -f ./docker-compose-lingh.yml pull
docker compose -f ./docker-compose-lingh.yml up -d

# ... Wait five seconds for HiveServer2 to finish initializing. Visit `localhost:24225` to verify that initialization is complete.

./mvnw clean test

docker compose -f ./docker-compose-lingh.yml down
```

- Log as follows.

```shell
$ ./mvnw clean test
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< com.lingh:hivesever2-v400-sd-test >------------------
[INFO] Building hivesever2-v400-sd-test 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] 2 problems were encountered while building the effective model for org.apache.yetus:audience-annotations:jar:0.5.0
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ hivesever2-v400-sd-test ---
[INFO] Deleting /home/linghengqian/TwinklingLiftWorks/git/public/hivesever2-v400-sd-test/target
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ hivesever2-v400-sd-test ---
[INFO] skip non existing resourceDirectory /home/linghengqian/TwinklingLiftWorks/git/public/hivesever2-v400-sd-test/src/main/resources
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ hivesever2-v400-sd-test ---
[INFO] No sources to compile
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ hivesever2-v400-sd-test ---
[INFO] skip non existing resourceDirectory /home/linghengqian/TwinklingLiftWorks/git/public/hivesever2-v400-sd-test/src/test/resources
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ hivesever2-v400-sd-test ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 1 source file with javac [debug target 22] to target/test-classes
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ hivesever2-v400-sd-test ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.lingh.HiveTest
log4j:WARN No appenders could be found for logger (com.zaxxer.hikari.HikariConfig).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
testhivedrivertable
key     int
value   string
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.286 s -- in com.lingh.HiveTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.139 s
[INFO] Finished at: 2024-08-02T12:56:43+08:00
[INFO] ------------------------------------------------------------------------

```
