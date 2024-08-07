build:
	mvn clean package

run:
	mvn spring-boot:run

docker-build:
	docker-compose build

docker-up:
	docker-compose up
