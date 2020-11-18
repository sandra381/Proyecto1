import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.Color;
import java.awt.event.*;

public class Server implements ActionListener{
    protected JTextArea tex;
    protected BufferedReader pn;
    protected DataOutputStream out;
    static int puerto = 1200;
    public Server() {
        JFrame frame = new JFrame("**Server**");
        
        JTextArea tex= new JTextArea();
        tex.setBounds(12, 10, 374,450);
        frame.add(tex);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(400, 510);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent e) {
        try{
            Socket socservidor = new Socket("localhost",puerto);
            InputStreamReader inp = new InputStreamReader(socservidor.getInputStream());
            BufferedReader pn = new BufferedReader(inp);

            PrintWriter devolver = new PrintWriter(socservidor.getOutputStream(),true);
            devolver.println("Conexion Exitosa!"); 
            tex.append("Server: Ingrese Usuario \n");
            
        }catch (IOException a){
         a.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Server h = new Server();
        ServerSocket servi = new ServerSocket(puerto);
        System.out.println("Escuchando conexiòn por el puerto "+ puerto);
        Socket socliente = servi.accept();
        System.out.println("Conexiòn aceptada");
        BufferedReader nop = new BufferedReader(new InputStreamReader(socliente.getInputStream()));
        DataOutputStream ou = new DataOutputStream(socliente.getOutputStream());
        ConnectServer t2 = new ConnectServer(nop, ou);
        t2.start();
        
    }
       
}
