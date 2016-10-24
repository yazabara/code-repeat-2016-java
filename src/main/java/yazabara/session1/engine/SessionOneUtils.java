package yazabara.session1.engine;

import yazabara.session1.engine.field.Cell;
import yazabara.session1.engine.field.Field;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by yazab on 24.10.2016.
 */
public class SessionOneUtils {

    public static List<List<Cell>> getFirstState(int w, int h) {
        return IntStream.range(0, w).mapToObj(value -> castToCell(generateIntRow(h))).collect(Collectors.toList());
    }

    private static List<Integer> generateIntRow(int size) {
        Random random = new Random(new Date().getTime());
        return IntStream.range(0, size).map(operand -> (random.nextInt(2))).boxed().collect(Collectors.toList());
    }

    private static List<Cell> castToCell(List<Integer> src) {
        return src.stream().map(integer -> new Cell(integer == 1)).collect(Collectors.toList());
    }

    public static String printField(Field field) {
        return field.getField().stream().map(cells -> cells.stream().map(cell -> cell.isAlive() ? "1 " : "0 ").reduce(String::concat)).map(Optional::get).reduce((s, s2) -> s + "\n" + s2).get();
    }
}
