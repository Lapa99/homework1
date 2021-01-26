import java.io.*;
public class Dz3 {
    private File messageHistoryFile;

    public void showAlert(String msg) {
        int lineNumber = 0;
        if (setMessageHistoryFile().exists()) {
            try (FileReader fr = new FileReader(messageHistoryFile)) {
                LineNumberReader lnr = new LineNumberReader(fr);
                while (lnr.readLine() != null) {
                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedReader br = new BufferedReader(new FileReader(messageHistoryFile))) {
                for (int i = 0; i < lineNumber; i++) {
                    String line = br.readLine();
                    if (i >= lineNumber - 100) {
                        textArea.appendText(line + "\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                messageHistoryFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File setMessageHistoryFile() {
        messageHistoryFile = new File("client/data/nickname=" + nickname + ".cmh");
        return messageHistoryFile;
    }
}