package backend.academy.starter;

import backend.academy.enums.Difficult;
import backend.academy.model.Session;
import backend.academy.service.CategoryService;
import backend.academy.service.CategoryServiceImpl;
import backend.academy.service.GameService;
import backend.academy.service.GameServiceImpl;
import backend.academy.service.OutputService;
import backend.academy.service.OutputServiceImpl;
import backend.academy.service.WordService;
import backend.academy.service.WordServiceImpl;

public class MainStarter implements Starter {
    private final CategoryService categoryService;
    private final GameService gameService;
    private final OutputService outputService;
    private final WordService wordService;

    @Override
    public void start() {
        String categoryChoose = gameService.categoryChoose();
        if (categoryChoose == null) {
            categoryChoose = String.valueOf(categoryService.getRandomCategoryNumber());
        }
        categoryChoose = categoryService.findCategory(categoryChoose);
        outputService.print("Chosen category : " + categoryChoose + "\n");
        Difficult difficultChoose = gameService.difficultChoose();
        switch (difficultChoose) {
            case Difficult.EASY:
                outputService.print("Chosen difficult : Easy\n");
                break;
            case Difficult.MEDIUM:
                outputService.print("Chosen difficult  : Medium\n");
                break;
            case Difficult.HARD:
                outputService.print("Chosen difficult  : Hard\n");
                break;
            default:
                outputService.print("There is no such difficult, type another one");
                break;
        }
        GameStarter gameController = new GameStarter(new Session(
            wordService.chooseWordByDifficultFromList(categoryService.getWordsListByCategory(categoryChoose),
                difficultChoose)));
        gameController.start();
    }

    public MainStarter() {
        categoryService = new CategoryServiceImpl();
        gameService = new GameServiceImpl();
        outputService = new OutputServiceImpl();
        wordService = new WordServiceImpl();
    }
}
