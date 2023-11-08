package service;

import model.Words;
import service.impl.FileService;


import java.io.*;

public class FileServiceImpl implements FileService {

    private static final String WORD_FILE = "Words.txt";

    @Override
    public Words[] readFile()  {
        File file = new File(WORD_FILE);

        try (InputStream inputStream = new FileInputStream(file);

            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            byte[] bytes = bufferedInputStream.readAllBytes();

            String wordFile = new String(bytes);
            String[] keyAndValues = wordFile.split("\n");
            System.out.println(keyAndValues.length);
            Words[] word = new Words[keyAndValues.length];

            for (int i = 0; i < word.length; i++) {
                String[] keyAndValue = keyAndValues[i].split(":");
                word[i] = new Words(keyAndValue[0], keyAndValue[1]);
            }
            return word;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean writeFile(Words word) {
        File file = new File(WORD_FILE);
        try (OutputStream outputStream = new FileOutputStream(file, true)) {
            outputStream.write(word.toString().getBytes());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
