package old.manager;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;

public class GPSServer{

	Connection conn;
	
	ServerSocket server;
	EquipManager manager;

	public GPSServer() throws IOException {
		server = new ServerSocket(10000);
		System.out.println("调用构造方法"+server);
		manager = new EquipManager();
	}

	public void run(){
		
		startServer();
		
	}

	private void startServer() {
		for(int i = 0;;i++){
			System.out.println("waiting equip to connect!");
			try {
				GPSEquipment equip = new GPSEquipment(server.accept() , this.manager);
				equip.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args){
		try {
			new GPSServer().run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
