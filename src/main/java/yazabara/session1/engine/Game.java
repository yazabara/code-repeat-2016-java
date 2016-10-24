package yazabara.session1.engine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import yazabara.session1.engine.field.Field;

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
        state = new Field(SessionOneUtils.getFirstState(width, height));
        applicationEventPublisher.publishEvent(new StateCompletedEvent(this, state));

        IntStream.range(1, iteration).forEach(value -> nextState());
    }

    private void nextState() {
        //TODO implement logic
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
