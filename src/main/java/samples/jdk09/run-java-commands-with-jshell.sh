#!/bin/bash

clear
DIR=`dirname "$0"`
JAVA_FILE="$DIR/JshellJavaCommands.txt"
echo "Running '$JAVA_FILE' in jshell"
echo ""
echo "If you want to try by typing your own commands, just execute jshell without any parameter at a terminal."
jshell "$JAVA_FILE"