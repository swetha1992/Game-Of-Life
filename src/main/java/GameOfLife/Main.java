package GameOfLife;

import GameOfLife.Game.Game;
import GameOfLife.Model.Cell;
import GameOfLife.Model.VitalityOfCell;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cell> inputCells = new ArrayList<>();
        inputCells.add(new Cell(1, 1, VitalityOfCell.ALIVE));
        inputCells.add(new Cell(1, 2, VitalityOfCell.ALIVE));
        inputCells.add(new Cell(2, 1, VitalityOfCell.ALIVE));
        inputCells.add(new Cell(2, 2, VitalityOfCell.ALIVE));
        Game game = new Game(inputCells);
        List<Cell> outputCells = game.play();
        System.out.println("Universe Before Transition");
        inputCells.forEach(cell -> System.out.println(cell.getPositionX() + "," + cell.getPositionY() + "," + cell.getStatus()));
        System.out.println("Universe After Transition");
        outputCells.forEach(cell -> System.out.println(cell.getPositionX() + "," + cell.getPositionY() + "," + cell.getStatus()));
    }
}

