package yazabara;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

/**
 * Created by yazab on 25.10.2016.
 */
@Component
public abstract class AbstractGame implements ApplicationEventPublisherAware {

    @Value("${width}")
    protected int width;

    @Value("${height}")
    protected int height;

    @Value("${iteration}")
    protected int iteration;

    private ApplicationEventPublisher applicationEventPublisher = null;

    public void startGame() {
        prepareFirstState();
        IntStream.range(1, iteration).forEach(value -> nextState());
    }

    protected abstract void prepareFirstState();

    protected abstract void calculateNextState();

    protected abstract ApplicationEvent getEvent();

    private void nextState() {
        calculateNextState();
        notifyObservers();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    private void notifyObservers() {
        applicationEventPublisher.publishEvent(getEvent());
    }
}
