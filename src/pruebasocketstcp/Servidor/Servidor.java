package pruebasocketstcp.Servidor;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Servidor {
 
      static  ServerSocket servidor;
      static  Socket sc;
      static  DataInputStream in;
      static  DataOutputStream out;
      static final int PUERTO = 53000; //Puerto expuesto en el servidor
 
 
    public static void main(String[] args) {
 
    
       
        try {
            
            //Habilitamos la conexion contra el servidor reservando el puerto 5300
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
 
            //Espero a que llegue informacion desde socket del servidor
            while (true) {
 
                //Acepto la conexion del cliente
                sc = servidor.accept();

                //Habilito la entrada/salida de info con el cliente
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                //Notifico de la conexion en el servidor
                System.out.println("Cliente conectado");
                
                //Notifico de la conexion en el cliente
                out.writeUTF("Servidor: conexion aceptada y confirmada");               
              
         
                //Codifico a UTF la informacion entrante del cliente
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                //Cierro el socket
                sc.close();
                System.out.println("Cliente desconectado");
 
            }
 
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
 
}