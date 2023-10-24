package worksheetk;

public class Main {
    public static void main(String[] args) {
        SurveyStationAccess s = new SurveyStationAccess("/Users/olepearse-danker/git/repository/lab_vs_01/bin/worksheetk/Messdaten.txt");
        
        System.out.println("Anzahl Messstationen in Deutschland: " + s.getStationCount());
        
        // Methode die die beiden Messstationen

    }

}