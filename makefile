sync:
	@echo "---> make sync <---"
	mvn dependency:resolve -Dclassifier=sources -Dclassifier=javadoc

build:
	@echo "---> make build <---"
	mvn package

test:
	@echo "---> make test <---"
	mvn test

clean:
	@echo "---> make clean <---"
	rm -rf target

docker_build:
	@echo "---> make docker build <---"