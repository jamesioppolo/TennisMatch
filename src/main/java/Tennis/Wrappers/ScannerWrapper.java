package Tennis.Wrappers;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ScannerWrapper {
    Scanner keyboard = new Scanner(System.in);

    public Integer nextInt() {
        return keyboard.nextInt();
    }
}
