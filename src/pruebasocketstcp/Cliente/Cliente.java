/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasocketstcp.Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Cliente {
 
    public static void main(String[] args) {
 
        //Host del servidor
        final String HOST = "127.0.0.1";
        //Puerto del servidor
        final int PUERTO = 53000;
        DataInputStream in;
        DataOutputStream out;
 
        try {
            
            for (int i = 1; i < 2; i++) {
                
            //Creo el enlace con el servidor
            Socket sc = new Socket(HOST, PUERTO);
 
            //Habilito la entrada de informacion desde el servidor
            in = new DataInputStream(sc.getInputStream());
            
            //Habilito la salida de informacion hacia el servidor
            out = new DataOutputStream(sc.getOutputStream());
 
            //Envio un mensaje al servidor codificado en UTF
            out.writeUTF("Cliente: Mensaje nº"+i);
 
            //Codifico a UTF la informacion que llega desde del servidor
            String mensaje = in.readUTF();
 
            //La muestro por pantalla
            System.out.println(mensaje);
            
            //Cierro conexion
            sc.close();
            }
            
 
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
 
}