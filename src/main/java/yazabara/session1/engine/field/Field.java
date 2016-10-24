package yazabara.session1.engine.field;

import java.util.Collections;
import java.util.List;

/**
 * Created by yazab on 24.10.2016.
 */
public final class Field {

    private final List<List<Cell>> field;

    public Field(List<List<Cell>> field) {
        this.field = field;
    }

    public List<List<Cell>> getField() {
        return Collections.unmodifiableList(this.field);
    }
}
