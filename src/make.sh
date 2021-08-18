#!/bin/sh

find -name '*.java' | xargs javac
java com.codecool.polishdraughts.PolishDraughts 
