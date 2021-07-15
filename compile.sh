#!/bin/bash
javac -d "classes" -sourcepath src src/*.java
javac -d "classes" -sourcepath src/model src/model/*.java
javac -d "classes" -sourcepath src/primitive src/primitive/*.java
javac -d "classes" -sourcepath src src/executor/*.java
