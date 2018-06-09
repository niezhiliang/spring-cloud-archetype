cd spring-cloud-engine/

#用来解决engine代码改变显示找不到符号问题
mvn clean install -Dmaven.test.skip=true

cd ../spring-cloud-eureka/

mvn clean package -DskipTests=true docker:build

cd ../spring-cloud-config/

mvn clean package -DskipTests=true docker:build


cd ../spring-cloud-gateway/

mvn clean package -DskipTests=true docker:build

cd ../spring-cloud-service/

cd service-B/

mvn clean package -DskipTests=true docker:build

cd ../service-A/

mvn clean package -DskipTests=true docker:build
