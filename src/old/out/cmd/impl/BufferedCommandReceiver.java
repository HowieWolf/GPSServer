package old.out.cmd.impl;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

import old.out.DataFlag;
import old.out.cmd.CommandReceiver;
import old.out.model.Command;

public class BufferedCommandReceiver extends BufferedInputStream implements CommandReceiver{

	public BufferedCommandReceiver(InputStream in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 读取一整条指令，以DATASTRAT开始，以DATAEND结束 首先检测DATASTART， 跳过一个逗号开始读取指令内容
	 * 顺序读入指令类容，根据传输协议，到DATAEND之前的内容最短是28位，在这期间不用判断是否到DATAEND
	 * 
	 * 同时检测DATAEND
	 * 
	 * @return
	 * @throws EOFException
	 * @throws IOException
	 */
	@Override
	public String readCommand() throws EOFException, IOException {
		StringBuffer cmd = new StringBuffer();

		detectStart();
		this.skip(1);
		for (int i = 0; i < Command.MIN_LENGTH; i++) {
			cmd.append((char) this.read());
		}
		char c;
		boolean end = false;
		while (!end) {
			c = (char) this.read();
			if (c == 'D') {
				this.mark(10);
				if (detectEnd()) {
					end = true;
					cmd.deleteCharAt(cmd.length()-1);
					break;
				} else {
					cmd.append(c);
					this.reset();
				}
			} else {
				cmd.append(c);
			}
		}

		return cmd.toString();
	}

	private boolean detectEnd() throws IOException {
		boolean flag = false;
		StringBuffer end = new StringBuffer();
		end.append('D');
		for (int i = 0; i < 6; i++) {
			end.append((char) this.read());
		}
		if (end.toString().equals(DataFlag.DATA_END)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 检测DATASTART
	 * 
	 * @return
	 * @throws IOException
	 */
	private void detectStart() throws IOException {
		boolean flag = false;// 标记是否找到DATASTART
		while (!flag) {
			int c = this.read();
			if (c == 'D') {
				this.mark(10);
				StringBuffer start = new StringBuffer();
				start.append('D');
				for (int i = 0; i < 8; i++) {
					start.append((char) this.read());
				}
				if (start.toString().equals(DataFlag.DATA_START)) {
					flag = true;
					break;
				} else {
					this.reset();
					continue;
				}
			}
		}
	}
}
