package programs;

import com.battle.heroes.army.Army;
import com.battle.heroes.army.Unit;
import com.battle.heroes.army.programs.PrintBattleLog;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class SimulateBattleImplTest {

    @Test
    public void testSimulate() throws InterruptedException {
        SimulateBattleImpl simulator = new SimulateBattleImpl();
        PrintBattleLog mockLog = mock(PrintBattleLog.class);
        simulator.setPrintBattleLog(mockLog);

        Army playerArmy = // Создайте армию игрока
                Army computerArmy = // Создайте армию компьютера

                simulator.simulate(playerArmy, computerArmy);

        // Проверьте, что логирование вызывалось
        verify(mockLog, atLeastOnce()).printBattleLog(any(Unit.class), any(Unit.class));
    }
}