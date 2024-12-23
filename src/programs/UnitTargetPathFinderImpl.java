package programs;

import com.battle.heroes.army.Unit;
import com.battle.heroes.army.programs.Edge;
import com.battle.heroes.army.programs.UnitTargetPathFinder;

import java.util.*;

public class UnitTargetPathFinderImpl implements UnitTargetPathFinder {

    @Override
    public List<Edge> getTargetPath(Unit attackUnit, Unit targetUnit, List<Unit> existingUnitList) {
        // Инициализация структур данных для алгоритма A*
        PriorityQueue<EdgeDistance> openSet = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));
        Map<Edge, Edge> cameFrom = new HashMap<>();
        Map<Edge, Integer> gScore = new HashMap<>();
        Map<Edge, Integer> fScore = new HashMap<>();

        Edge start = new Edge(attackUnit.getX(), attackUnit.getY());
        Edge goal = new Edge(targetUnit.getX(), targetUnit.getY());

        openSet.add(new EdgeDistance(start.x, start.y, 0));
        gScore.put(start, 0);
        fScore.put(start, heuristic(start, goal));

        while (!openSet.isEmpty()) {
            Edge current = openSet.poll();

            if (current.equals(goal)) {
                return reconstructPath(cameFrom, current);
            }

            for (Edge neighbor : getNeighbors(current, existingUnitList)) {
                int tentativeGScore = gScore.get(current) + 1;
                if (tentativeGScore < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, tentativeGScore + heuristic(neighbor, goal));
                    openSet.add(new EdgeDistance(neighbor.x, neighbor.y, tentativeGScore));
                }
            }
        }

        return Collections.emptyList(); // Путь не найден
    }

    private int heuristic(Edge a, Edge b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private List<Edge> getNeighbors(Edge edge, List<Unit> existingUnitList) {
        List<Edge> neighbors = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] dir : directions) {
            int newX = edge.x + dir[0];
            int newY = edge.y + dir[1];
            Edge newEdge = new Edge(newX, newY);

            if (isValid(newEdge, existingUnitList)) {
                neighbors.add(newEdge);
            }
        }

        return neighbors;
    }

    private boolean isValid(Edge edge, List<Unit> existingUnitList) {
        for (Unit unit : existingUnitList) {
            if (unit.getX() == edge.x && unit.getY() == edge.y) {
                return false;
            }
        }
        return true;
    }

    private List<Edge> reconstructPath(Map<Edge, Edge> cameFrom, Edge current) {
        List<Edge> path = new ArrayList<>();
        path.add(current);

        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            path.add(0, current);
        }

        return path;
    }
}