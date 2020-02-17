package cat.paucasesnovescifp.sppsp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {

        // Creamos bloque de variables que vamos a usar
        DatagramSocket socket;
        Scanner sc = new Scanner(System.in);
        DatagramPacket paqueteA;
        DatagramPacket paqueteB;
        String mensaje;
        String mensaje2;
        byte[] buf;



        try {
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            //creamos el datagrama socket
            socket = new DatagramSocket();
            //pillamos el mensaje del scanner
            mensaje = sc.nextLine();
            // Inicializamos el paquete que vamos a mandar a B
            paqueteA = new DatagramPacket(mensaje.getBytes(),mensaje.length(),ip,5555);
            // Enviamos el paquete con el mensaje
            socket.send(paqueteA);
            // Cerramos el socket
            socket.close();


            // Inicializamos el socket de recibir
            socket = new DatagramSocket(5556);
            buf = new byte[1024];
            // Inicializamos el paquete con un tamaño
            paqueteB = new DatagramPacket(buf,1024);
            // Esperamos a recibir el paquete
            socket.receive(paqueteB);
            // Creamos un string con los datos que vienen del paquete
            mensaje2 = new String(paqueteB.getData(),0,paqueteB.getLength());
            System.out.println(mensaje2);
            // Cerramos el socket
            socket.close();


        } catch (IOException e) {
            System.out.println("Error de A: " + e.getMessage());
        }

    }

}
