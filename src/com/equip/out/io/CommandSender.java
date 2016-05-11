package com.equip.out.io;

import java.io.IOException;

public interface CommandSender {
	
	public void writeCommand(String cmd) throws IOException;
	
	//public void close() throws IOException;

}
