import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockStellarBurgersTest {

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockSauce;

    @Mock
    Ingredient mockFilling;

    private Burger burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
    }

    @Test
    void setBunsTest() {
        Burger newBurger = new Burger();
        newBurger.setBuns(mockBun);
        assertEquals(mockBun, newBurger.bun);
    }

    @Test
    void addIngredientTest() {
        Burger newBurger = new Burger();
        newBurger.addIngredient(mockSauce);
        assertEquals(1, newBurger.ingredients.size());
        assertTrue(newBurger.ingredients.contains(mockSauce));
    }

    @Test
    void removeIngredientTest() {
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockFilling, burger.ingredients.get(0));
    }

    @Test
    void moveIngredientTest() {
        Ingredient mockIngredient3 = mock(Ingredient.class);
        burger.addIngredient(mockIngredient3);
        burger.moveIngredient(0, 2);
        assertEquals(mockFilling, burger.ingredients.get(0));
        assertEquals(mockIngredient3, burger.ingredients.get(1));
        assertEquals(mockSauce, burger.ingredients.get(2));
    }

    @Test
    void getReceiptTest() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn((float) 100);
        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn("hot sauce");
        when(mockSauce.getPrice()).thenReturn((float) 100);
        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(mockFilling.getName()).thenReturn("cutlet");
        when(mockFilling.getPrice()).thenReturn((float) 100);

        String actual = burger.getReceipt();
        float expectedPrice = burger.getPrice();

        String expected = String.format("(==== %s ====)%n", mockBun.getName())
                + String.format("= %s %s =%n", mockSauce.getType().toString().toLowerCase(), mockSauce.getName())
                + String.format("= %s %s =%n", mockFilling.getType().toString().toLowerCase(), mockFilling.getName())
                + String.format("(==== %s ====)%n", mockBun.getName())
                + String.format("%nPrice: %f%n", expectedPrice);

        assertEquals(expected, actual);
    }
}
