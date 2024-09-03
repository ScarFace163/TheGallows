package backend.academy.controller;

import backend.academy.model.Session;
import backend.academy.service.CategoryService;
import backend.academy.service.CategoryServiceImpl;
import backend.academy.service.InputOutputService;
import backend.academy.service.InputOutputServiceImpl;
import backend.academy.service.WordService;
import backend.academy.service.WordServiceImpl;

public class MainController implements Controller {
    CategoryService categoryService;
    InputOutputService inputOutputService;
    WordService wordService;

    @Override
    public void control() {
        String categoryChoose = inputOutputService.printCategoryChoose();
        if (categoryChoose==null) {
            categoryChoose = String.valueOf(categoryService.getRandomCategoryNumber());
        }
        categoryChoose =  categoryService.findCategory(categoryChoose);
        System.out.println("Chosen category : " + categoryChoose +"\n");
        int difficultChoose = inputOutputService.printDifficultChoose();
        switch (difficultChoose){
            case 1:
                System.out.println("Chosen difficult : Easy\n");
                break;
            case 2:
                System.out.println("Chosen difficult  : Medium\n");
                break;
            case 3:
                System.out.println("Chosen difficult  : Hard\n");
                break;
        }
        GameController gameController = new GameController(new Session(wordService.chooseWordByDifficultFromList(categoryService.getWordsListByCategory(categoryChoose),difficultChoose)));
        gameController.control();
    }

    public MainController() {
        categoryService = new CategoryServiceImpl();
        inputOutputService = new InputOutputServiceImpl();
        wordService = new WordServiceImpl();
    }
}
