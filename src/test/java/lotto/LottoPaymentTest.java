package lotto;

import lotto.model.LottoPayment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaymentTest {


    @DisplayName("로또 한트 게임에 천원 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1",
            "10000:10",
            "14000:14",
            "500:0",
            "900:0"},
            delimiter = ':')
    void LOTTO_PRICE_TEST(String payPrice, int lottoCount) {
        LottoPayment lottoPayment = new LottoPayment();
        assertThat(lottoPayment.pay(payPrice)).isEqualTo(lottoCount);
    }

}
