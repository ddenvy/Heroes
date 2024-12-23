package programs;

import com.battle.heroes.army.Unit;
import com.battle.heroes.army.programs.Edge;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTargetPathFinderImplTest {

    @Test
    public void testGetTargetPath() {
        UnitTargetPathFinderImpl finder = new UnitTargetPathFinderImpl();
        Unit attackUnit = // Создайте атакующего юнита
                Unit targetUnit = // Создайте цель атаки
                List<Unit> existingUnitList = // Создайте список существующих юнитов

                        List<Edge> path = finder.getTargetPath(attackUnit, targetUnit, existingUnitList);

        // Проверьте, что путь найден корректно
        assertEquals(expectedPath, path);
    }
}