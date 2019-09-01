package Tennis.Wrappers;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ScannerWrapper {
    private Scanner keyboard;

    public ScannerWrapper() {
        this.initialiseScanner();
    }

    private void initialiseScanner() {
        this.keyboard = new Scanner(System.in);
    }

    public Integer nextInt() {
        try {
            return keyboard.nextInt();
        } catch(Exception e) {
            keyboard.reset();
            this.initialiseScanner();
            return 0;
        }
    }
}
