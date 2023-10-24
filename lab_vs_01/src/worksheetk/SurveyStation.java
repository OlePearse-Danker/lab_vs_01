package worksheetk;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SurveyStation {
	
    private short stationId;
    private Calendar startDate;
    private Calendar finishDate;
    private short altitude;
    private double latitude;
    private double longitude;
    private String stationName;
    private String federalState;

    public SurveyStation(short stationId, String startDate, String finishDate, short altitude,
                         double latitude, double longitude, String stationName, String federalState) {
    	
        this.stationId = stationId;
        this.startDate = calendarFormatOf(startDate);
        this.finishDate = calendarFormatOf(finishDate);
        this.altitude = altitude;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stationName = stationName;	
        this.federalState = federalState;
        
        // System.out.println(stationId + startDate + finishDate + altitude + latitude + longitude + stationName + federalState);
        System.out.println(stationId + ", " + startDate + ", " + finishDate + ", " + altitude + ", " + latitude + ", " + longitude + ", " + stationName + ", " + federalState);

    }


    public String getFederalState(String s) {
    return s;
    }
    
    public void setFederalState(String federalState) {
        this.federalState = federalState;
    }
    
    
    public Calendar calendarFormatOf(String sD) {

		try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(sD));

//          System.out.println("Calendar created from integer: " + c.getTime());
            return c;
        } catch (Exception e) {
        	System.out.println("Datum konnte nicht verarbeitet werden!");
        }
		
		return null;
	}
    
	public short getAltitude () {
		return altitude;
	}
	
	public double getLatitude () {
		return latitude;
	}
	
	public double getLongitude () {
		return longitude;
	}
	
	public String getStationName () {
		return stationName;
	}
    
  
}

