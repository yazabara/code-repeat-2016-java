package yazabara.session2;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import yazabara.AbstractGame;

/**
 * Created by yazab on 25.10.2016.
 */
@Component
public class SecondGame extends AbstractGame {

    @Override
    protected void prepareFirstState() {

    }

    @Override
    protected void calculateNextState() {

    }

    @Override
    protected ApplicationEvent getEvent() {
        return null;
    }
}
