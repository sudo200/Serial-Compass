package at.htlstp.gratzer.fabian.Serial_Compass.com;

import com.fazecast.jSerialComm.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ComListener {
    private final SerialPort port;

    public ComListener(@NotNull String port) {
        this.port = SerialPort.getCommPort(port);
        this.port.openPort();
    }

    public void addDataListener(Consumer<byte[]> function) {
        port.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent e) {
                if(e.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
                    return;

                byte[] data = new byte[port.bytesAvailable()];
                port.readBytes(data, port.bytesAvailable());
                function.accept(data);
            }
        });
    }
}
