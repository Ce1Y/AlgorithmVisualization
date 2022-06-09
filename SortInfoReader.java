package src.classSrc;

import java.io.*;

public class SortInfoReader {

    private String content;

    public SortInfoReader(String fileNameText) {
        File file = new File(fileNameText);
        this.content = readToString(file);
    }

    public static String readToString(File file) {
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(filecontent);
    }

    public String getContent() {
        return content;
    }
}
