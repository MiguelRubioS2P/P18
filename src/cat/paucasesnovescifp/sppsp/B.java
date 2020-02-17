package cat.paucasesnovescifp.sppsp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class B {

    public static void main(String[] args) {

        DatagramSocket socket;
        byte[] buf;
        DatagramPacket paqueteB;
        DatagramPacket paqueteA;
        String mensaje;
        String mensaje2;

        try {
            // Creamos socket de recibr
            socket = new DatagramSocket(5555);
            buf = new byte[1024];
            // Creamos paquete
            paqueteB = new DatagramPacket(buf,1024);
            // Esperamos
            socket.receive(paqueteB);
            mensaje = new String(paqueteB.getData(),0,paqueteB.getLength());
            System.out.println(mensaje);
            // Cerramos
            socket.close();

            InetAddress ip = InetAddress.getByName("127.0.0.1");
            // Incializamos socket de enviar
            socket = new DatagramSocket();
            mensaje2 = "rebut";
            paqueteA = new DatagramPacket(mensaje2.getBytes(),mensaje2.length(),ip,5556);
            // Enviamos
            socket.send(paqueteA);
            // Cerramos
            socket.close();

        } catch (IOException e) {
            System.out.println("Error en B: " + e.getMessage());
        }

    }

}
