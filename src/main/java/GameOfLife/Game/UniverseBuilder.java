package GameOfLife.Game;

import GameOfLife.Model.Cell;
import GameOfLife.Model.Universe;
import GameOfLife.Model.VitalityOfCell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UniverseBuilder {

    List<Cell> aliveCells;

    public UniverseBuilder(List<Cell> aliveCells) {
        this.aliveCells = aliveCells;
    }

    public int determineMaximunOfXCoordinates() {
        return aliveCells.stream().max(compareX()).get().getPositionX();
    }

    public int determineMinimumOfXCoordinates() {

        return aliveCells.stream().min(compareX()).get().getPositionX();

    }

    public int determineMaximunOfYCoordinates() {
        return aliveCells.stream().max(compareY()).get().getPositionY();

    }

    public int determineMinimumOfYCoordinates() {
        return aliveCells.stream().min(compareY()).get().getPositionY();
    }

    private Comparator<Cell> compareX() {
        final Comparator<Cell> compX = (cellOne, cellTwo) -> Integer.compare(cellOne.getPositionX(), cellTwo.getPositionX());
        return compX;
    }

    private Comparator<Cell> compareY() {
        final Comparator<Cell> compY = (cellOne, cellTwo) -> Integer.compare(cellOne.getPositionY(), cellTwo.getPositionY());
        return compY;
    }

    public Universe buildUniverse() {
        int maximumOfX = determineMaximunOfXCoordinates();
        int minimumOfX = determineMinimumOfXCoordinates();
        int maximumOfY = determineMaximunOfYCoordinates();
        int minimumOfY = determineMinimumOfYCoordinates();
        List<Cell> cells = new ArrayList<>();
        for (int positionX = minimumOfX - 1; positionX <= maximumOfX + 1; positionX++) {
            for (int positionY = minimumOfY - 1; positionY <= maximumOfY + 1; positionY++) {
                if (isCellVital(positionX, positionY)) {
                    cells.add(new Cell(positionX, positionY, VitalityOfCell.ALIVE));
                } else {
                    cells.add(new Cell(positionX, positionY, VitalityOfCell.DEAD));
                }
            }
        }
        return new Universe(cells);
    }

    private Boolean isCellVital(int positionX, int positionY) {
        for (Cell cell : aliveCells) {
            if (cell.getPositionX() == positionX && cell.getPositionY() == positionY) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
