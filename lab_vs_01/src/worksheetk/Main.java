package worksheetk;

public class Main {
    public static void main(String[] args) {
    	
    	// TASK 01
    	
		
		/*
		 * SurveyStationAccess s = new SurveyStationAccess(
		 * "/Users/olepearse-danker/git/repository/lab_vs_01/bin/worksheetk/Messdaten.txt"
		 * );
		 * 
		 * // TASK 02
		 * 
		 * System.out.println("Anzahl Messstationen in Deutschland: " +
		 * s.getStationCount());
		 * 
		 * SurveyStation lowestStation = s.findLowestStation();
		 * System.out.println("Messstation mit niedrigster Höhe: " +
		 * lowestStation.getStationName() + " mit der Höhe " +
		 * lowestStation.getAltitude() );
		 * 
		 * SurveyStation highestStation = s.findHighestStation();
		 * System.out.println("Messstation mit höchster Höhe: " +
		 * highestStation.getStationName() + " mit der Höhe " +
		 * highestStation.getAltitude() );
		 * 
		 * SurveyStation northernmostStation = s.findNorthernmostStation();
		 * System.out.println("Nördlichste Messstation: " +
		 * northernmostStation.getStationName() + " " +
		 * northernmostStation.getLatitude() );
		 * 
		 * SurveyStation southernmostStation = s.findSouthernmostStation();
		 * System.out.println("Süderste Messstation: " +
		 * southernmostStation.getStationName() + " " +
		 * southernmostStation.getLatitude() );
		 * 
		 * SurveyStation easternmostStation = s.findEasternmostStation();
		 * System.out.println("Easterste Messstation: " +
		 * easternmostStation.getStationName() + " " + easternmostStation.getLongitude()
		 * );
		 * 
		 * SurveyStation westernmostStation = s.findWesternmostStation();
		 * System.out.println("Westlichste Messstation: " +
		 * westernmostStation.getStationName() + " " + westernmostStation.getLongitude()
		 * );
		 */
        

        
        // TASK 03
        
		
		  WindDataAccess w = new WindDataAccess(
			// filename
		  "/Users/olepearse-danker/git/repository/lab_vs_01/src/worksheetk/winddata.txt"
		  	// enter "direction"/"speed" for corresponding averageCalculation 
		  );
		  
		  
		// Get Amount of WindData
		  System.out.println("Anzahl Winddateien: " + String.format("%30s", w.getwindDataCount()));

		  // Get DirectionAverage
		  System.out.println("Durchschnittliche Windrichtung: " + String.format("%30s", w.getAverage("direction")));

		  // Get SpeedAverage
		  System.out.println("Durchschnittliche Windgeschwindigkeit: " + String.format("%23s", w.getAverage("speed")));

		 
       
        
    }

}