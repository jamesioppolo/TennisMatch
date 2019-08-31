package Tennis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(TennisMatchApplication.class);
		TennisMatchApplication tennisMatch = context.getBean(TennisMatchApplication.class);
		tennisMatch.start();
	}
}
