package src.classSrc;

import java.io.*;

public class SortInfoReader {

    private String content;

    public SortInfoReader(String fileNameText) {
        File file = new File(fileNameText);
        this.content = readToString(file);
    }

    public SortInfoReader(String fileNameText, String encoding) {
        if (encoding.equals("UTF-8"))
            this.content = readUTF8File(fileNameText);
        else
            this.content = "the encoding must be UTF-8!";
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

    public static String readUTF8File(String fileNameText) {
        String encoding = "utf8";
        String text = "";
        try {
            InputStream is = new FileInputStream(fileNameText);
            int iAvail = is.available();
            byte[] bytes = new byte[iAvail];
            is.read(bytes);
            text = new String(bytes, encoding);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}
