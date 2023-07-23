.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app

start:
	./gradlew clean
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

clear:
	./gradlew clean
	./gradlew installDist
	./build/install/app/bin/app -h

.PHONY: build