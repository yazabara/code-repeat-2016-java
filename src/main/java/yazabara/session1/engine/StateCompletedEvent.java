package yazabara.session1.engine;

import org.springframework.context.ApplicationEvent;
import yazabara.session1.FirstGame;
import yazabara.session1.engine.field.Field;

/**
 * Created by yazab on 24.10.2016.
 */
public class StateCompletedEvent extends ApplicationEvent {

    private Field state;

    public StateCompletedEvent(FirstGame source, Field state) {
        super(source);
        this.state = state;
    }

    public Field getState() {
        return state;
    }
}
