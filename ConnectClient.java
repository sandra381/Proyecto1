import java.net.Socket;
import javax.swing.JTextArea;
import java.io.*;
import java.net.*;
public class ConnectClient extends Thread{
    protected JTextArea tex;
    protected BufferedReader pn;
    protected DataOutputStream out;
    public ConnectClient(Socket sck, JTextArea tex)throws Exception{
        pn = new BufferedReader(new InputStreamReader(sck.getInputStream()));
        out = new DataOutputStream(sck.getOutputStream());
    }
    public void mandar(String textoen)throws IOException{
        out.write((textoen + "\n").getBytes());

    }
    public void run(){
        String textoen = "";
        try{
            while(true){
                textoen = pn.readLine();
                if(textoen==null ){
                    break;
                }else{

                }tex.append("Server:"+textoen+"\n");
            }
        }catch (Exception a){
            a.printStackTrace();
        }
    }

}