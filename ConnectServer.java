import java.io.*;
import java.net.*;
public class ConnectServer extends Thread{
    static int puerto=1200;
    protected BufferedReader en;
    protected DataOutputStream sal;
    public ConnectServer(BufferedReader en,DataOutputStream sal){
        this.en = en;
        this.sal=sal;
    }
    public void run(){
        String texto= "";
        try{
            while(true){
                texto= en.readLine();
                System.out.println("Client:"+texto);
                sal.write((texto+"\n").getBytes());        
            }
        }catch (Exception a){
            a.printStackTrace();
            System.exit(1);
        }
    }
    public static void main(String[] args) throws Exception{
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