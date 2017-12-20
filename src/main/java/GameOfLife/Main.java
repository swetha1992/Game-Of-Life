package GameOfLife;

import GameOfLife.Exceptions.InvalidCoordinatesException;
import GameOfLife.Game.Game;
import GameOfLife.Model.Cell;
import GameOfLife.Model.VitalityOfCell;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception, InvalidCoordinatesException {
        List<Cell> inputCells = new ArrayList<>();
        inputCells.add(new Cell(1,2, VitalityOfCell.ALIVE));
        inputCells.add(new Cell(2,4,VitalityOfCell.ALIVE));
        inputCells.add(new Cell(3,8,VitalityOfCell.ALIVE));
        Game game=new Game(inputCells);
        game.play();

    }
}

