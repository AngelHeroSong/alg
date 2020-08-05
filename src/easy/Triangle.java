package easy;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList(rowIndex + 1);

        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
            for (int j = i -1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;

    }
}
