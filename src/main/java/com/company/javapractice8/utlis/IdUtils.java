package com.company.javapractice8.utlis;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.IntStream;

@UtilityClass
public class IdUtils {

    public int newId(String pattern, List<String> existentValues) {
        List<Integer> existentIds = existentValues.stream()
                .filter(name -> name.startsWith(pattern))
                .mapToInt(name -> {
                    try {
                        return Integer.parseInt(name.substring(pattern.length() + 1));
                    } catch (NumberFormatException exception) {
                        return -1;
                    }
                })
                .boxed().toList();
        return IntStream.range(0, Integer.MAX_VALUE).filter(id -> !existentIds.contains(id)).findFirst().orElse(-1);
    }
}
