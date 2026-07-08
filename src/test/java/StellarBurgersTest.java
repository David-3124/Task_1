import org.junit.jupiter.api.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StellarBurgersTest {

    @Test
    void bunNameTest() {
        Bun bun = new Bun("black bun", 100);
        assertEquals("black bun", bun.getName());
    }

    @Test
    void bunPriceTest() {
        Bun bun = new Bun("black bun", 100);
        assertEquals(100, bun.getPrice());
    }

    @Test
    void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    void ingredientNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals("sour cream", ingredient.getName());
    }

    @Test
    void ingredientPriceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals(200, ingredient.getPrice());
    }

    @Test
    void ingredientTypeSauceTest() {
        IngredientType[] types = IngredientType.values();
        assertTrue(Arrays.asList(types).contains(IngredientType.SAUCE));
    }

    @Test
    void ingredientTypeFillingTest() {
        IngredientType[] types = IngredientType.values();
        assertTrue(Arrays.asList(types).contains(IngredientType.FILLING));
    }
}
