package old.out.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import old.out.DataFlag;

public class ReplyBootCommand extends Command {

	String dateTime;

	public ReplyBootCommand() {
		// TODO Auto-generated constructor stub
		dateTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String reply = DataFlag.DATA_START + "," + DataFlag.REPLY_BOOT + "," + dateTime + ","
				+ DataFlag.CRCR + "," + DataFlag.DATA_END;
		return reply;
	}

}
