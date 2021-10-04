package regexp;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFormatting {

    private static final String IN_FILE = "src/main/resources/fails/inFile.txt";
    private static final String OUT_FILE = "src/main/resources/fails/outFile.txt";

    private String formattingPhoneNumber(String textFile) {
        Pattern pattern = Pattern.compile("(\\+\\d)(\\(\\d{3}\\))([ ]\\d{3}[ ]\\d{2}[ ]\\d{2})");
        Matcher matcher = pattern.matcher(textFile);
        String correctNumberPhone = "";
        while (matcher.find()) {
            String phone = matcher.group().replaceAll("\\W","");
            correctNumberPhone = correctNumberPhone.concat(phone + "\n");
        }
        return correctNumberPhone;
    }

    private String readFromFile() throws IOException {
        String s = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(IN_FILE))) {
            s = reader.readLine();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return s;
    }

    public void createAndWrite() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUT_FILE))) {
            String resultText = formattingPhoneNumber(readFromFile());
            writer.write(resultText);
        }catch (IOException e) {
            e.getMessage();
        }
    }
}
