.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app

start:
	./gradlew clean
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/file1.yml src/test/resources/file2.yml

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