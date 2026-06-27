import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParameterizedStellarBurgersTest {

    static Stream<Arguments> burgerPriceTestData() {
        return Stream.of(
                Arguments.of(100, List.of(50, 30), 280),
                Arguments.of(200, List.of(), 400),
                Arguments.of(150, List.of(20, 30, 40), 390)
        );
    }

    @ParameterizedTest
    @MethodSource("burgerPriceTestData")
    void burgerPriceTest(float bunPrice, List<Integer> ingredientPrices, float expectedPrice) {
        Bun mockBun = mock(Bun.class);
        when(mockBun.getPrice()).thenReturn(bunPrice);

        Burger burger = new Burger();
        burger.setBuns(mockBun);

        for (int price : ingredientPrices) {
            Ingredient mockIngredient = mock(Ingredient.class);
            when(mockIngredient.getPrice()).thenReturn((float) price);
            burger.addIngredient(mockIngredient);
        }
        assertEquals(expectedPrice, burger.getPrice());
    }
}