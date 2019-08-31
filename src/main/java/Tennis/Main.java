package Tennis;

import Tennis.Services.TennisMatchApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("Tennis");
		context.refresh();

		TennisMatchApplication tennisMatch = context.getBean(TennisMatchApplication.class);
		tennisMatch.start();
	}
}
