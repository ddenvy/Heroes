package programs;

import com.battle.heroes.army.Unit;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuitableForAttackUnitsFinderImplTest {

    @Test
    public void testGetSuitableUnits() {
        SuitableForAttackUnitsFinderImpl finder = new SuitableForAttackUnitsFinderImpl();
        List<List<Unit>> unitsByRow = // Создайте массив юнитов для теста
        boolean isLeftArmyTarget = true;

        List<Unit> suitableUnits = finder.getSuitableUnits(unitsByRow, isLeftArmyTarget);

        // Проверьте, что возвращены только подходящие юниты
        assertEquals(expectedCount, suitableUnits.size());
    }
}