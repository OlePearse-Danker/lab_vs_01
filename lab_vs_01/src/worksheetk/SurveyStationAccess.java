package worksheetk;

import java.util.ArrayList;

public class SurveyStationAccess extends FileAccessViaBytes {
	private int DATASET_LENGTH = 1002;
	private int PRELIMINARIES = 211;
	private ArrayList<SurveyStation> stations;
	private int stationCount;
	
	public SurveyStationAccess(String fileName) {
		super(fileName);
		readSurveyStations();
		super.close();
	}
	
	public ArrayList<SurveyStation> getSurveyStations() {
		return stations;
	}
	
	
	public void readSurveyStations() {
		stations = new ArrayList<SurveyStation>();
		
		try {
			this.readNBytes(PRELIMINARIES);
		} catch (Exception e) {
			
		}
		
		// System.out.println("Reading data now...");
		
		String buffer = "";
		
		while (true) {
			
			try {
				buffer = this.readNBytes(DATASET_LENGTH);
			
				if (buffer != null) {
					String[] stationData = analyseString(buffer);
					

					SurveyStation ss = new SurveyStation(
							Short.parseShort(stationData[0]),
							stationData[1],
							stationData[2],
							Short.parseShort(stationData[3]),
							Double.parseDouble(stationData[4]),
							Double.parseDouble(stationData[5]),
							stationData[6],
							stationData[7]
							);
					
					stations.add(ss);
					stationCount++;
				}
			} catch (Exception e) {
				// System.err.println(e);
				break;
			}
		}

	}
	
	private String[] analyseString(String s) {

		String[] result = new String[8];

		String item = s.substring(0, 5);
		result[0] = removeSpaces(item); 	//id

		item = s.substring(6, 14); 
		result[1] = removeSpaces(item);	//von Datum
		
		item = s.substring(15, 24);
		result[2] = removeSpaces(item);	//bis Datum

		item = s.substring(34, 38); //25
		result[3] = removeSpaces(item);	//höhe
		
		item = s.substring(39, 51);
		result[4] = removeSpaces(item);	//latitude

		item = s.substring(52, 60);
		result[5] = removeSpaces(item);	//longitude

		item = s.substring(61, 101);
		result[6] = removeSpaces(item);	//stationsname
		
		item = s.substring(102, 132);
		result[7] = removeSpaces(item);	//bundesland	

		
		return result;
	}

	private String removeSpaces(String s) {

		String stringWithoutSpaces = s.trim();
		return stringWithoutSpaces;
	}
	
	
	public int getStationCount() {
		return stationCount;
	}
	
	
	public int getNumberOfSurveyStations() {
		return stations.size();
	}

	public SurveyStation findLowestStation() {
		if (stations.isEmpty()) {
			return null;
		}

		SurveyStation lowestStation = stations.get(0);

		for (SurveyStation station : stations) {
			if (station.getAltitude() < lowestStation.getAltitude()) {
				lowestStation = station;
			}
		}
		return lowestStation;
	}

	public SurveyStation findHighestStation() {
		if (stations.isEmpty()) {
			return null;
		}
		SurveyStation highestStation = stations.get(0);

		for (SurveyStation station : stations) {
			if (station.getAltitude() > highestStation.getAltitude()) {
				highestStation = station;
			}
		}
		return highestStation;
	}
	
	public SurveyStation findNorthernmostStation() {
		if (stations.isEmpty()) {
			return null;
		}
		SurveyStation northernmostStation = stations.get(0);

		for (SurveyStation station : stations) {
			if (station.getLatitude() > northernmostStation.getLatitude()) {
				northernmostStation = station;
			}
		}
		return northernmostStation;
	}
	
	public SurveyStation findSouthernmostStation() {
	    if (stations.isEmpty()) {
	        return null;
	    }
	    SurveyStation southernmostStation = stations.get(0);

	    for (SurveyStation station : stations) {
	        if (station.getLatitude() < southernmostStation.getLatitude()) {
	            southernmostStation = station;
	        }
	    }
	    return southernmostStation;
	}

	public SurveyStation findEasternmostStation() {
	    if (stations.isEmpty()) {
	        return null;
	    }
	    SurveyStation easternmostStation = stations.get(0);

	    for (SurveyStation station : stations) {
	        if (station.getLongitude() > easternmostStation.getLongitude()) {
	            easternmostStation = station;
	        }
	    }
	    return easternmostStation;
	}

	public SurveyStation findWesternmostStation() {
	    if (stations.isEmpty()) {
	        return null;
	    }
	    SurveyStation westernmostStation = stations.get(0);

	    for (SurveyStation station : stations) {
	        if (station.getLongitude() < westernmostStation.getLongitude()) {
	            westernmostStation = station;
	        }
	    }
	    return westernmostStation;
	}

}
	
	
	