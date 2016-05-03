package old.out.cmd.impl;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import old.out.cmd.CommandSender;

public class BufferedCommandSender extends BufferedOutputStream implements CommandSender {

	public BufferedCommandSender(OutputStream arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void writeCommand(String cmd) throws IOException {
		this.write(cmd.getBytes());
		this.flush();
	}

}
