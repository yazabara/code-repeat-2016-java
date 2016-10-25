package yazabara.session1.engine.field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yazab on 24.10.2016.
 */
public final class Field {

    private final List<List<Cell>> field;

    public Field(List<List<Cell>> field) {
        this.field = Collections.unmodifiableList(field);
    }

    public List<List<Cell>> getField() {
        return Collections.unmodifiableList(this.field);
    }

    public List<Cell> getNeighbors(int x, int y) {
        //TODO remove loop
        //TODO remove if statement
        List<Cell> neighbors = new ArrayList<>();
        for (int i = 0; i < field.size(); i++) {
            for (int j = 0; j < field.get(i).size(); j++) {
                if ((Math.abs(i - x) == 1 && Math.abs(j - y) < 2) || (Math.abs(j - y) == 1 && Math.abs(i - x) < 2)) {
                    neighbors.add(new Cell(field.get(i).get(j).isAlive()));
                }
            }
        }
        return Collections.unmodifiableList(neighbors);
    }
}
