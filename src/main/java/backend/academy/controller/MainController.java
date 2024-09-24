package backend.academy.controller;

import backend.academy.enums.Difficult;
import backend.academy.model.Session;
import backend.academy.service.CategoryService;
import backend.academy.service.CategoryServiceImpl;
import backend.academy.service.InputOutputService;
import backend.academy.service.InputOutputServiceImpl;
import backend.academy.service.WordService;
import backend.academy.service.WordServiceImpl;

public class MainController implements Controller {
    private final CategoryService categoryService;
    private final InputOutputService inputOutputService;
    private final WordService wordService;

    @Override
    public void control() {
        String categoryChoose = inputOutputService.printCategoryChoose();
        if (categoryChoose == null) {
            categoryChoose = String.valueOf(categoryService.getRandomCategoryNumber());
        }
        categoryChoose = categoryService.findCategory(categoryChoose);
        inputOutputService.print("Chosen category : " + categoryChoose + "\n");
        Difficult difficultChoose = inputOutputService.printDifficultChoose();
        switch (difficultChoose) {
            case Difficult.EASY:
                inputOutputService.print("Chosen difficult : Easy\n");
                break;
            case Difficult.MEDIUM:
                inputOutputService.print("Chosen difficult  : Medium\n");
                break;
            case Difficult.HARD:
                inputOutputService.print("Chosen difficult  : Hard\n");
                break;
            default:
                inputOutputService.print("There is no such difficult, type another one");
                break;
        }
        GameController gameController = new GameController(new Session(
            wordService.chooseWordByDifficultFromList(categoryService.getWordsListByCategory(categoryChoose),
                difficultChoose)));
        gameController.control();
    }

    public MainController() {
        categoryService = new CategoryServiceImpl();
        inputOutputService = new InputOutputServiceImpl();
        wordService = new WordServiceImpl();
    }
}
