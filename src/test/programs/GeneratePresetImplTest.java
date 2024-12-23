package programs;

import com.battle.heroes.army.Army;
import com.battle.heroes.army.Unit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneratePresetImplTest {

    @Test
    public void testGenerate() {
        GeneratePresetImpl generator = new GeneratePresetImpl();
        List<Unit> unitList = // Создайте список юнитов для теста
        int maxPoints = 1500;

        Army army = generator.generate(unitList, maxPoints);

        // Проверьте, что армия создана корректно
        assertEquals(maxPoints, army.getPoints());
        // Добавьте другие проверки
    }
}