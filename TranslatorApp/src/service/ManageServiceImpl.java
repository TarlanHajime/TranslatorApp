package service;

import model.Words;
import service.impl.ManageService;
import util.MenuUtil;

public class ManageServiceImpl implements ManageService {

    private final GameService gameService;

    public ManageServiceImpl() {
        gameService = new GameService();
    }

    @Override
    public void manage() {

        while (true) {
            int option = MenuUtil.firstMenu();

            switch (option) {
                case 0:
                    System.exit(-1);
                case 1:
                    gameService.start();
                    break;
                case 2:
                    gameService.addWords();
                    break;
                case 3:
                    gameService.seeHistory();
                    break;
                default:
                    System.out.println("Option is invalid!");
            }
        }
    }
}