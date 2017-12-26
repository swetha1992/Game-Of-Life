package GameOfLife;

import GameOfLife.Game.Game;
import GameOfLife.Game.UniverseBuilder;
import GameOfLife.Model.Cell;
import GameOfLife.Model.Universe;
import GameOfLife.Model.VitalityOfCell;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GameTest {

    @Test
    public void shouldVerifyIfMaximumOfXIsThreeForInputsAtOneCommaTwoAndTwelveCommaSix() {
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1, 12, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4, 6, VitalityOfCell.ALIVE));
        UniverseBuilder universeBuilder = new UniverseBuilder(aliveCells);
        Assert.assertEquals(4, universeBuilder.determineMaximunOfXCoordinates());
    }

    @Test
    public void shouldVerifyIfMinimumOfXIsThreeForInputsAtOneCommaTwoAndTwelveCommaSix() {
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1, 12, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4, 6, VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        UniverseBuilder universeBuilder = new UniverseBuilder(aliveCells);
        Assert.assertEquals(1, universeBuilder.determineMinimumOfXCoordinates());
    }

    @Test
    public void shouldVerifyIfMaximumOfYIsThreeForInputsAtOneCommaTwoAndTwelveCommaSix() {
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1, 12, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4, 6, VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        UniverseBuilder universeBuilder = new UniverseBuilder(aliveCells);
        Assert.assertEquals(12, universeBuilder.determineMaximunOfYCoordinates());
    }

    @Test
    public void shouldVerifyIfMinimumOfYIsThreeForInputsAtOneCommaTwoAndTwelveCommaSix() {
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1, 12, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4, 6, VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        UniverseBuilder universeBuilder = new UniverseBuilder(aliveCells);
        Assert.assertEquals(6, universeBuilder.determineMinimumOfYCoordinates());
    }

    @Test
    public void shouldBuildUniverseWithCellCountTwenty() {
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(2, 5, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4, 4, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(3, 4, VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        UniverseBuilder universeBuilder = new UniverseBuilder(aliveCells);
        Assert.assertEquals(20, universeBuilder.buildUniverse().getCells().size());

    }

    @Test
    public void shouldBuildUniverseWithAliveCellCountThree() {
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(2, 5, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4, 4, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(3, 4, VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        UniverseBuilder universeBuilder = new UniverseBuilder(aliveCells);
        List<Cell> cells = universeBuilder.buildUniverse().getCells();
        long liveCellCount = cells.stream().filter(cell -> cell.getStatus().equals(VitalityOfCell.ALIVE)).count();
        Assert.assertEquals(3, liveCellCount);

    }

    @Test
    public void shouldBuildUniverseWithDeadCellCountSeventeen() {
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(2, 5, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(4, 4, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(3, 4, VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        UniverseBuilder universeBuilder = new UniverseBuilder(aliveCells);
        List<Cell> cells = universeBuilder.buildUniverse().getCells();
        long liveCellCount = cells.stream().filter(cell -> cell.getStatus().equals(VitalityOfCell.DEAD)).count();
        Assert.assertEquals(17, liveCellCount);
    }

    @Test
    public void shouldMakeTransitionOnUniverse() {
        List<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(0, 1, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(1, 0, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(2, 1, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(0, 2, VitalityOfCell.ALIVE));
        aliveCells.add(new Cell(1, 2, VitalityOfCell.ALIVE));
        Game game = new Game(aliveCells);
        UniverseBuilder universeBuilder = new UniverseBuilder(aliveCells);
        universeBuilder.buildUniverse().getCells().forEach(cell -> System.out.println(cell.getPositionX() + "," + cell.getPositionY() + "," + cell.getStatus()));
        Assert.assertEquals(25, universeBuilder.buildUniverse().getCells().size());
        Universe universe = game.makeTransition();
        System.out.println("-----");
        universe.getCells().forEach(cell -> System.out.println(cell.getPositionX() + "," + cell.getPositionY() + "," + cell.getStatus()));
    }

}
