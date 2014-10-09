package edu.upc.eetac.dsa.yifeige.Ejercicio12Cliente_UDP;
import java.io.*;
import java.net.*;

public class Ejercicio12Cliente_UDP 
{
    public static void main( String[] args )throws IOException
    {
    	DatagramSocket socket=new DatagramSocket();
        String Hostname="127.0.0.1";
        int portNumber=9876;
        BufferedReader lector_usuario=new BufferedReader(new InputStreamReader(System.in));
 	    System.out.println("Por favor tecla 0 para obtener la hora actual");
 	    int opcion=Integer.parseInt(lector_usuario.readLine());
 	    if(opcion==0)
 	    {
 	    	String opcion1="0";// opcion es un string
 	        byte[] sendbuff=new byte[256];
 	        byte[] receivebuff=new byte[256];
 	        sendbuff=opcion1.getBytes();//codifico a mi opcion para poner meter dentro del buff
 	        InetAddress address=InetAddress.getByName(Hostname);	        
 	        DatagramPacket paquete=new DatagramPacket(sendbuff,sendbuff.length,address,portNumber);
 	        socket.send(paquete);//envio mi buff
 	        
 	        paquete=new DatagramPacket(receivebuff,receivebuff.length);
 	        socket.receive(paquete);
 	        
 	        String resultado=new String(paquete.getData(),0,paquete.getLength());
 	        System.out.printf("La hora actual es %s", resultado);
 	        System.out.print("Gracias por usar el servicio\n");
 	        System.exit(1);
 	        
 	    }
 	    else
 	    {
 	    	System.out.print("Error! cerramos la conexion");
 	    	System.exit(1);
 	    }
 	    
        
    }
}
