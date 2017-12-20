package GameOfLife;

import GameOfLife.Exceptions.InvalidCoordinatesException;
import GameOfLife.Game.Game;
import GameOfLife.Model.Cell;
import GameOfLife.Model.Universe;
import GameOfLife.Model.VitalityOfCell;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GameTest {

    @Test
    public void shouldValidateTrueForPositiveCordinates() throws Exception, InvalidCoordinatesException {
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1,2, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(2,3,VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        Assert.assertTrue(game.validateInputCoordinates(aliveCells));
    }
    @Test(expected = InvalidCoordinatesException.class)
    public void shouldThrowExceptionForNegativeCoordinates() throws Exception, InvalidCoordinatesException {
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1,-2, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(2,3,VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        game.validateInputCoordinates(aliveCells);
    }
    @Test
    public void shouldVerifyIfMaximumOfXIsThreeForInputsAtOneCommaTwoAndTwelveCommaSix(){
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1,12, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4,6,VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        Assert.assertEquals(4,game.determineMaximunOfXCoordinates());
    }
    @Test
    public void shouldVerifyIfMinimumOfXIsThreeForInputsAtOneCommaTwoAndTwelveCommaSix(){
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1,12, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4,6,VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        Assert.assertEquals(1,game.determineMinimumOfXCoordinates());
    }

    @Test
    public void shouldVerifyIfMaximumOfYIsThreeForInputsAtOneCommaTwoAndTwelveCommaSix(){
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1,12, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4,6,VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        Assert.assertEquals(12,game.determineMaximunOfYCoordinates());
    }
    @Test
    public void shouldVerifyIfMinimumOfYIsThreeForInputsAtOneCommaTwoAndTwelveCommaSix(){
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1,12, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4,6,VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        Assert.assertEquals(6,game.determineMinimumOfYCoordinates());
    }
    @Test
    public void shouldBuildUniverseWithCellCountTwenty(){
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(2,5, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4,4,VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(3,4,VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        game.buildUniverse();
        Assert.assertEquals(20,game.buildUniverse().getCells().size());

    }
    @Test
    public void shouldBuildUniverseWithAliveCellCountThree(){
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(2,5, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4,4,VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(3,4,VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        game.buildUniverse();
        List<Cell> cells= game.buildUniverse().getCells();
        long liveCellCount = cells.stream().filter(cell -> cell.getStatus().equals(VitalityOfCell.ALIVE)).count();
        Assert.assertEquals(3,liveCellCount);

    }
    @Test
    public void shouldBuildUniverseWithDeadCellCountSeventeen(){
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(2,5, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4,4,VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(3,4,VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        game.buildUniverse();
        List<Cell> cells= game.buildUniverse().getCells();
        long liveCellCount = cells.stream().filter(cell -> cell.getStatus().equals(VitalityOfCell.DEAD)).count();
        Assert.assertEquals(17,liveCellCount);
    }
    @Test
    public void shouldMakeTransitionOnUniverse(){
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(2,5, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4,4,VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(3,4,VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        Universe universe = game.buildUniverse();
        game.makeTransitionOnUniverse();
    }

}
