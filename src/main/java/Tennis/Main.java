package Tennis;

import org.joda.time.LocalTime;

public class Main {
	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);
		TennisMatchApplication greeter = new TennisMatchApplication();
		System.out.println(greeter.sayHello());
	}
}
