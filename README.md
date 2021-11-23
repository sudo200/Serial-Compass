# Serial Compass
A simple program written in Java for emulating a compass through an Arduino connected through serial.

## Usage
1. Download [here](https://github.com/sudo200/Serial-Compass/releases/latest).
2. If you don't already have Java 8, install it.
3. open a terminal in the directory, where the program is located, and type `java -jar <filename-wit-extention> <serial-port>`.

To get the serial port, take a look onto the bottom right corner of the Arduino IDE.

A window showing a compass needle should now pop up.

To control it using an Arduino, call `Serial.write((<angle-in-degree>/360.0)*127)`.

## Simple test program
```javascript
/**
 * Fabian Gratzer 2021
 * v1.0 | 23.11.2021
 * Simple demo program
 */
 
uint16_t i = 0;

void setup() {
  Serial.begin(9600);
}

void loop() {
  Serial.write(++i);
  i %= 128;
}
```
