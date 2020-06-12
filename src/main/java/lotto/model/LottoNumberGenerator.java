package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    public static final int LOTTO_RANGE_START_NUMBER = 1;
    public static final int LOTTO_RANGE_LAST_NUMBER = 45;
    public static final int LOTTO_CREATE_COUNT = 6;
    private static List<Integer> lottoNumbers = IntStream.rangeClosed(LOTTO_RANGE_START_NUMBER, LOTTO_RANGE_LAST_NUMBER)
                                                    .boxed()
                                                    .collect(Collectors.toList());

    public static List<Integer> getAutoNumber(){
        List<Integer> lottoNumber = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < LOTTO_CREATE_COUNT; i++) {
            lottoNumber.add(lottoNumbers.get(i));
        }
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public static List<Integer> getManualNumber(String manualNumber){
        return Arrays.asList(manualNumber.split(",")).stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
