package yazabara.session1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import yazabara.session1.engine.Game;
import yazabara.session1.engine.SessionOneUtils;
import yazabara.session1.engine.StateCompletedEvent;
import yazabara.session1.engine.field.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yazab on 24.10.2016.
 */
@Component
public class GameRunner implements CommandLineRunner, ApplicationListener<StateCompletedEvent> {

    private final Logger logger = LoggerFactory.getLogger(GameRunner.class);

    private final Game game;

    private List<Field> states = new ArrayList<>();

    @Autowired
    public GameRunner(Game game) {
        this.game = game;
    }

    public void startGame() {
        game.startGame();
    }

    @Override
    public void run(String... args) throws Exception {
        startGame();
    }

    @Override
    public void onApplicationEvent(StateCompletedEvent event) {
        states.add(event.getState());
        logger.info("\n State: \n" + SessionOneUtils.printField(states.get(states.size() - 1)));
    }
}
