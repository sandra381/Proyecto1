import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.Color;
import java.awt.event.*;

public class Client implements ActionListener{
    protected JTextArea tex;
    static Socket socservidor;
    protected JTextField cam;
    static ConnectClient con;
    public Client() {
        JFrame frame = new JFrame("**Cliente**");

        cam= new JTextField();
        cam.setBounds(10, 450, 291,20);
        frame.add(cam);

        JButton button = new JButton("enviar");
        button.setBounds(310, 450, 80, 20);
        button.addActionListener(this);
        frame.add(button);

        tex= new JTextArea();
        tex.setBounds(10, 10, 374,430);
        frame.add(tex);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(400, 510);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void conectarSer(){
        try{
            socservidor = new Socket("localhost",Server.puerto);
            con = new ConnectClient(socservidor,tex);
            con.start();
        }catch (Exception a ){
            a.printStackTrace();
            System.exit(1);
        }
    }

    public void actionPerformed(ActionEvent e) {
        try{
            Socket socservidor = new Socket("localhost",ConnectServer.puerto);
            tex.append("Client:"+ cam.getText()+"\n");
            cam.setText("");
            
        }catch (IOException a ){
         a.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Client h = new Client();
    }
       
}
