import java.lang.Math;
import java.util.Scanner;

//Weather class
class weather {
    private int tempF;
    private int windSpeed;
    public double windChill;//declaration of variables
    public boolean severe;

    //default constructor
    public weather() {
        tempF = 5;
        windSpeed = 40;
        //windChill = 0;
    }
    public weather(int tempF, int windSpeed) {
        this.tempF = tempF;
        this.windSpeed = windSpeed;
    }
    //gets methods
    public int getTempF() {
        return tempF;
    }
    //set methods
    public void setTempF(int tempF ) {
        if(tempF > -50 && tempF < 150){
            this.tempF = tempF;
        }
        return;
    }
    public double getWindSpeed() {
        return windSpeed;
    }
    public void setWindSpeed(int windSpeed) {
        if(windSpeed >= 0){
            this.windSpeed = windSpeed;
        }
        return;
    }

    public double getWindChill() {
        int t = getTempF();
        double v = getWindSpeed();

        windChill = 35.74 + 0.6215*t - 35.75*Math.pow(v, 0.16) + 0.4275*t*Math.pow(v,0.16); // calculates the windchill
        return windChill;
    }
    public boolean isSevere() {
        if(getWindChill() < -15) { // calculates if it is severe
            severe = true;
        }
        else {
            severe = false;
        }
        return severe;
    }
    public String toString() {
        double wind = (Math.round(getWindChill()* 100.0) / 100.0);
        return "Current Temperature is " + tempF + " 'F. Feels like " + wind + " 'F and Wind Speed is " + windSpeed + " mph."; // prints the temerature and windchill
    }
}

class WeatherTester {

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        weather w = new weather();
        weather wT = new weather(11, 20);

        System.out.println(w);
        System.out.println(wT);
        System.out.println(w.isSevere() ? "Weather is severe!" : "Weather is ok");

        System.out.println("Enter the current Weather ");
        int temp = keyboard.nextInt();
        System.out.println("Enter the windspeed ");
        int windspeed = keyboard.nextInt();
        weather a = new weather(temp, windspeed);
        System.out.println(a);
    }
}
