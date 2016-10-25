package yazabara.session1.engine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import yazabara.session1.engine.field.Cell;
import yazabara.session1.engine.field.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by yazab on 24.10.2016.
 */
@Component
public class Game implements ApplicationEventPublisherAware {

    @Value("${width}")
    private int width;

    @Value("${height}")
    private int height;

    @Value("${iteration}")
    private int iteration;

    private Field state;

    private ApplicationEventPublisher applicationEventPublisher = null;

    public void startGame() {
        setState(new Field(SessionOneUtils.getFirstState(width, height)));

        IntStream.range(1, iteration).forEach(value -> nextState());
    }

    private void nextState() {
        //TODO remove loop
        //TODO remove if statement
        List<List<Cell>> field = state.getField();
        List<List<Cell>> newField = new ArrayList<>(field.size());
        for (int i = 0; i < field.size(); i++) {
            newField.add(new ArrayList<>(field.get(i).size()));
            for (int j = 0; j < field.get(i).size(); j++) {
                Cell cell = field.get(i).get(j);
                List<Cell> neighbors = state.getNeighbors(i, j);
                int aliveNeighborsCount = neighbors.stream().filter(Cell::isAlive).collect(Collectors.toList()).size();
                if (cell.isAlive() && aliveNeighborsCount < 1 || aliveNeighborsCount > 3) {
                    // kill
                    newField.get(i).add(j, new Cell(false));
                } else if (!cell.isAlive() && aliveNeighborsCount > 3) {
                    // resurrection
                    newField.get(i).add(j, new Cell(true));
                } else {
                    // save state
                    newField.get(i).add(j, new Cell(cell.isAlive()));
                }
            }
        }
        setState(new Field(newField));
    }

    private void setState(Field state) {
        this.state = state;
        applicationEventPublisher.publishEvent(new StateCompletedEvent(this, this.state));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
