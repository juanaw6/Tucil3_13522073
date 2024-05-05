#!/bin/bash

if [ -z "$DISPLAY" ]; then
    echo "Setting DISPLAY to :0.0"
    export DISPLAY=:0.0
fi

javac -d bin src/*.java
echo "Compiling done to ./bin"

cd bin
echo "Running"

java Main