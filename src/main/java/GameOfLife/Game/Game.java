package GameOfLife.Game;


import GameOfLife.Model.Cell;
import GameOfLife.Model.Universe;
import GameOfLife.Model.VitalityOfCell;

import java.util.List;

public class Game {
    List<Cell> aliveCells;
    UniverseBuilder universeBuilder;
    Universe universe;
    public Game(List<Cell> aliveCells) {
        this.aliveCells = aliveCells;
        createUniverse(aliveCells);
    }

    private void createUniverse(List<Cell> aliveCells){
        universeBuilder = new UniverseBuilder(aliveCells);
        universe = universeBuilder.buildUniverse();
    }

    public List<Cell> play() {
        Universe universe = makeTransition();
        return universe.getCells();
    }

    public Universe makeTransition() {
        for (Cell cell : universe.getCells()){
            applyTransitionOn(cell);
        }
        return universe;
    }

    private void applyTransitionOn(Cell cell) {
        int countOfLiveNeighbours = universe.determineCountOfLiveNeighbours(cell);
        if (cell.getStatus().equals(VitalityOfCell.ALIVE)) {
            if (countOfLiveNeighbours < 2 || countOfLiveNeighbours > 3) {
                cell.setStatus(VitalityOfCell.DEAD);
            }
        }else if(cell.getStatus().equals(VitalityOfCell.DEAD)){
            if(countOfLiveNeighbours == 3){
                cell.setStatus(VitalityOfCell.ALIVE);
            }
        }
    }
}
