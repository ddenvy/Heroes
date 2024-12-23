package programs;

import com.battle.heroes.army.Unit;
import com.battle.heroes.army.programs.SuitableForAttackUnitsFinder;

import java.util.ArrayList;
import java.util.List;

public class SuitableForAttackUnitsFinderImpl implements SuitableForAttackUnitsFinder {

    @Override
    public List<Unit> getSuitableUnits(List<List<Unit>> unitsByRow, boolean isLeftArmyTarget) {
        List<Unit> suitableUnits = new ArrayList<>();

        for (List<Unit> row : unitsByRow) {
            for (int i = 0; i < row.size(); i++) {
                if (isLeftArmyTarget) {
                    // Для левой армии (игрока) проверяем, что юнит не закрыт слева
                    if (i == 0 || row.get(i - 1) == null) {
                        suitableUnits.add(row.get(i));
                    }
                } else {
                    // Для правой армии (компьютера) проверяем, что юнит не закрыт справа
                    if (i == row.size() - 1 || row.get(i + 1) == null) {
                        suitableUnits.add(row.get(i));
                    }
                }
            }
        }

        return suitableUnits;
    }
}