.DEFAULT_GOAL := build-run

clean:
	make -C app clean

build-run: build run
.PHONY: build