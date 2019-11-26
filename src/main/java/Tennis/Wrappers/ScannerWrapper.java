package Tennis.Wrappers;

import org.springframework.stereotype.Service;
import java.util.Scanner;

@Service
public class ScannerWrapper {
    private Scanner scanner;

    public ScannerWrapper() {
        this.initialiseScanner();
    }

    private void initialiseScanner() {
        this.scanner = new Scanner(System.in);
    }

    public Integer nextInt() {
        try {
            return scanner.nextInt();
        } catch(Exception e) {
            scanner.reset();
            this.initialiseScanner();
            return 0;
        }
    }
}
