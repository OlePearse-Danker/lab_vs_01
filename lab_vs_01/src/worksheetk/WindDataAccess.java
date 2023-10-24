package worksheetk;

import java.util.ArrayList;

public class WindDataAccess extends FileAccessViaBytes{
	
	private final int DATASET_LENGTH = 48;
	private final int PRELIMINARIES  = 43;
	private ArrayList<WindData> data;
	private int windDataCounter = 0;

	
	public WindDataAccess(String fileName) {
		 super(fileName);
		 readWindData();
		 super.close();
	}
	
	public void readWindData() {
		data = new ArrayList<WindData>();
		
		try {
			this.readNBytes(PRELIMINARIES);
		} catch (Exception e) {
			
		}
		
		
		String buffer = "";
		
		while (true) {
			
			try {
				buffer = this.readNBytes(DATASET_LENGTH);
			
				if (buffer != null) {
					String[] windData = buffer.split(";");
					
					// short stationId, String date, byte quality, double speed, double direction

					WindData wd = new WindData(
							Short.parseShort(windData[0].trim()),
							windData[1].trim(),
							Byte.parseByte(windData[2].trim()),
							Double.parseDouble(windData[3].trim()),
							Double.parseDouble(windData[4].trim())
							);
					
					data.add(wd);
					windDataCounter++;
				}
			} catch (Exception e) {
				// System.err.println("I really like potatoes!");
				break;
			}
		}
	}
	
	public int getwindDataCount() {
		return windDataCounter;
	}
	
	
	
	

}
