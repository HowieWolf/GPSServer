package com.equip.out.io;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;

public interface CommandReceiver {
	
	public String readCommand() throws EOFException, SocketException ,IOException ;

	public void close() throws IOException;
}
