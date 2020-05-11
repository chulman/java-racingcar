package racingcar;


import java.util.*;

public class RacingGameResult {

    private final String SEPARATOR = ",";

    private final List<int[]> results = new ArrayList<>();
    private Car[] cars;

    public RacingGameResult(Car[] cars) {
        this.cars = cars;
    }

    public void add(int[] records) {
        results.add(records);
    }

    public int getSize() {
        return results.size();
    }

    public String getWinner() {
        StringJoiner joiner = new StringJoiner(SEPARATOR);

        int max = Arrays.stream(results.get(results.size() - 1))
                .max()
                .orElseThrow(() -> new NoSuchElementException());

        Arrays.stream(cars)
                .map(Car::getPosition)
                .filter(position -> position == max)
                .map(String::valueOf)
                .forEach(joiner::add);

        return joiner.toString();
    }
}
