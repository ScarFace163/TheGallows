package backend.academy.controller;

import backend.academy.model.Session;
import backend.academy.service.CategoryService;
import backend.academy.service.CategoryServiceImpl;
import backend.academy.service.InputOutputService;
import backend.academy.service.InputOutputServiceImpl;
import backend.academy.service.WordService;
import backend.academy.service.WordServiceImpl;
import java.util.Scanner;

public class MainController implements Controller {
    Scanner sc;
    CategoryService categoryService;
    InputOutputService inputOutputService;
    WordService wordService;

    @Override
    public void control() {
        String categoryChoose = inputOutputService.printCategoryChoose();
        if (categoryChoose==null) {
            categoryChoose = String.valueOf(categoryService.getRandomCategoryNumber());
        }
        categoryChoose =  categoryService.findCategory(Integer.parseInt(categoryChoose));
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
        sc = new Scanner(System.in);
        categoryService = new CategoryServiceImpl();
        inputOutputService = new InputOutputServiceImpl();
        wordService = new WordServiceImpl();
    }
}
