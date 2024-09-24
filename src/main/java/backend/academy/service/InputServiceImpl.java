package backend.academy.service;

import backend.academy.enums.Difficult;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class InputServiceImpl implements InputService {
    private final Scanner sc;
    private final CategoryService categoryService;
    private final Random random;

    public InputServiceImpl() {
        this.sc = new Scanner(System.in, StandardCharsets.UTF_8);
        this.categoryService = new CategoryServiceImpl();
        random = new Random();
    }

    @Override
    public String inputCategoryNumber() {
        String categoryChoose;
        do {
            categoryChoose = sc.nextLine();
            if (categoryChoose.isEmpty()) {
                return null;
            }
        } while (!categoryService.isValidCategoryNumber(categoryChoose));
        return categoryChoose;
    }

    @Override
    public int inputDifficultNumber() {
        String difficultChoose;
        do {
            difficultChoose = sc.nextLine();
            if (difficultChoose.isEmpty()) {
                return random.nextInt(Difficult.values().length);
            }
        } while (!"0".equals(difficultChoose) && !"1".equals(difficultChoose) && !"2".equals(difficultChoose));
        return Integer.parseInt(difficultChoose);
    }

    @Override
    public String input() {
        return sc.nextLine();
    }
}
