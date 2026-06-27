import org.junit.jupiter.api.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StellarBurgersTest {

    @Test
    void bunTest() {
        Bun bun = new Bun("black bun", 100);
        assertEquals("black bun", bun.getName());
        assertEquals(100, bun.getPrice());
    }

    @Test
    void ingredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("sour cream", ingredient.getName());
        assertEquals(200, ingredient.getPrice());
    }

    @Test
    void ingredientTypeTest() {
        IngredientType[] types = IngredientType.values();
        assertTrue(Arrays.asList(types).contains(IngredientType.SAUCE));
        assertTrue(Arrays.asList(types).contains(IngredientType.FILLING));
    }
}
