.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app

start:
	./gradlew clean
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

clear:
	./gradlew clean
	./gradlew installDist
	./build/install/app/bin/app -h

setup:
	./gradlew clean
	./gradlew installDist

report:
	./gradlew jacocoTestReport


.PHONY: build