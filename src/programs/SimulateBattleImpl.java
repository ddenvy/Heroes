package programs;

import com.battle.heroes.army.Army;
import com.battle.heroes.army.Unit;
import com.battle.heroes.army.programs.PrintBattleLog;
import com.battle.heroes.army.programs.SimulateBattle;

import java.util.*;

public class SimulateBattleImpl implements SimulateBattle {
    private PrintBattleLog printBattleLog;

    @Override
    public void simulate(Army playerArmy, Army computerArmy) throws InterruptedException {
        List<Unit> playerUnits = new ArrayList<>(playerArmy.getUnits());
        List<Unit> computerUnits = new ArrayList<>(computerArmy.getUnits());

        while (!playerUnits.isEmpty() && !computerUnits.isEmpty()) {
            // Сортируем юнитов по убыванию атаки
            playerUnits.sort((u1, u2) -> Integer.compare(u2.getBaseAttack(), u1.getBaseAttack()));
            computerUnits.sort((u1, u2) -> Integer.compare(u2.getBaseAttack(), u1.getBaseAttack()));

            // Ходы игрока
            for (Unit playerUnit : playerUnits) {
                if (!playerUnit.isAlive()) continue;
                Unit target = playerUnit.getProgram().attack();
                if (target != null) {
                    printBattleLog.printBattleLog(playerUnit, target);
                    if (!target.isAlive()) {
                        computerUnits.remove(target);
                    }
                }
            }

            // Ходы компьютера
            for (Unit computerUnit : computerUnits) {
                if (!computerUnit.isAlive()) continue;
                Unit target = computerUnit.getProgram().attack();
                if (target != null) {
                    printBattleLog.printBattleLog(computerUnit, target);
                    if (!target.isAlive()) {
                        playerUnits.remove(target);
                    }
                }
            }
        }

        // Определяем победителя
        if (playerUnits.isEmpty() && computerUnits.isEmpty()) {
            System.out.println("Ничья!");
        } else if (playerUnits.isEmpty()) {
            System.out.println("Компьютер победил!");
        } else {
            System.out.println("Игрок победил!");
        }
    }
}