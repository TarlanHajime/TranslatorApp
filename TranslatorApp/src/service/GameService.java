package service;

import exception.EnumExceptions;
import model.Words;
import service.impl.FileService;
import service.impl.GameServiceImpl;
import util.InputUtil;
import util.RandomUtil;

import java.time.*;

public class GameService implements GameServiceImpl {
    private final FileService fileService;

    public GameService() {
        fileService = new FileServiceImpl();

    }

   @Override
   public void start() {
        System.out.println(LocalTime.now());
        LocalTime start = LocalTime.now();
        Words[] word = fileService.readFile();

        int point = 0;
        for (int i = 0; i < 10; i++) {
            Words words = word[RandomUtil.getRandomIndex(word.length)];
            if (!words.isShowed()) {
                String value = InputUtil.inputRequiredString(words.getKey() + " ---> ");
                if (words.getValue().equals(value)) {
                    point++;
                }
                words.setShowed(true);
            } else {
                i--;
            }
        }
        System.out.println("Congrats! Your point is " + point + "!\n");
        if (point <= 2) {
            System.out.println("Your english level is A0!");
        } else if (point <= 4) {
            System.out.println("Your english level is A1!");
        } else if (point <= 6) {
            System.out.println("Your english level is B1!");
        } else if (point <= 8) {
            System.out.println("Your english level is C1!");
        } else if (point <= 10) {
            System.out.println("Your english level is C2!");
        }
        try {
        if (point == 0) {
            throw new Exception(EnumExceptions.ALL_WORDS_IS_WRONG.getMessage());
        }
    } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (point <= 3) {
            point--;
        }
        LocalTime end = LocalTime.now();
        System.out.println(LocalTime.now());
        System.out.println("Game time: " + Duration.between(start, end).getSeconds());
    }

    @Override
    public void addWords() {
        System.out.println("------- New Words! -------");
        String key = InputUtil.inputRequiredString("English: ");
        String value = InputUtil.inputRequiredString("Azerbaijan: ");
        boolean isAdded = fileService.writeFile(new Words(key,value));
        System.out.println(isAdded ? "Successfully!" : "Fail!");
        System.out.println("------- Finish! -------");
        }

    @Override
    public void seeHistory() {
        Words[] words = fileService.readFile();
        System.out.println(">>>>>> History <<<<<<");
        for (Words word : words) {
            System.out.println(words);
        }
            System.out.println("\n>>>>>> History <<<<<<\n");
        }
    }

