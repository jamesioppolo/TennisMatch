package Tennis.Wrappers;

import org.springframework.stereotype.Service;

@Service
public class ConsoleWrapper {
    public void printLine(String string) {
        System.out.println(string);
    }
}
