package programs;

import com.battle.heroes.army.Army;
import com.battle.heroes.army.Unit;
import com.battle.heroes.army.programs.GeneratePreset;

import java.util.*;

public class GeneratePresetImpl implements GeneratePreset {

    @Override
    public Army generate(List<Unit> unitList, int maxPoints) {
        // Сортируем юнитов по эффективности (атака + здоровье) / стоимость
        unitList.sort((u1, u2) -> Double.compare(
                (u2.getBaseAttack() + u2.getHealth()) / u2.getCost(),
                (u1.getBaseAttack() + u1.getHealth()) / u1.getCost()
        ));

        List<Unit> selectedUnits = new ArrayList<>();
        int remainingPoints = maxPoints;

        for (Unit unit : unitList) {
            int maxCount = Math.min(11, remainingPoints / unit.getCost());
            for (int i = 0; i < maxCount; i++) {
                selectedUnits.add(unit);
                remainingPoints -= unit.getCost();
            }
        }

        return new Army(selectedUnits, maxPoints - remainingPoints);
    }
}