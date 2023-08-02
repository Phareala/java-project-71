.DEFAULT_GOAL := build-run

build:
	make -C app build


clean:
	make -C app clean

build-run: build run
.PHONY: build