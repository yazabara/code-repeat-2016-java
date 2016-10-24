package yazabara.session1.engine.field;

/**
 * Created by yazab on 24.10.2016.
 */
public final class Cell {

    private boolean alive;

    public Cell() {
        alive = true;
    }

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

}
