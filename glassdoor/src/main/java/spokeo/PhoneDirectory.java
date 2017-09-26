package spokeo;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read phone numbers from random text file.
 * @author Ritesh Dalvi
 **/
public class PhoneDirectory {

    public static void main(String args[]) {

        final String file = "/Users/ritesh/Documents/Ritesh/cs-practise/glassdoor/src/main/java/spokeo/phonedirectory.text";

        try {
            final FileReader fileReader = new FileReader(file);
            final BufferedReader bf = new BufferedReader(fileReader);

            final List<String> phoneNumbers = new ArrayList<>();

            String readLine = null;

            while((readLine = bf.readLine())!=null) {

                if(isPhoneNumber(readLine)) {
                    phoneNumbers.add(readLine);
                }
            }


            for(final String phoneNumber : phoneNumbers) {
                System.out.println(phoneNumber);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static boolean isPhoneNumber(final String text) {

        if(text == null || text.trim().isEmpty()) {
            return false;
        }

        if(text.length() != 10) {
            return false;
        }

        char[] textChar = text.toCharArray();

        for(int i=0; i<textChar.length;i++) {

            if(!isDigit(textChar[i])) {
                return false;
            }
        }

        return true;
    }


    private static boolean isDigit(final char value) {

        if(value>='0' && value<='9') {
            return true;
        }

        return false;
    }
}
