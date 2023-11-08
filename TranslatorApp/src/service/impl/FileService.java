package service.impl;

import model.Words;

public interface FileService {
    Words[] readFile();
    boolean writeFile(Words word);

}
