package lotto;

import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.model.RankReward;
import lotto.model.RewardLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("로또 당첨번호 매칭")
    @ParameterizedTest
    @CsvSource(value = {
            "3:true",
            "4:false",
            "5:true",
            "6:false",},
            delimiter = ':')
    void LOTTO_WINNER_NUMBER_MATCHING(int matchingCount, boolean bonus) {
        List<RewardLotto> rewardLottos = new ArrayList<>();
        rewardLottos.add(new RewardLotto(matchingCount, bonus));

        RankReward reward = new LottoResult(rewardLottos).getLottoResult();
        assertThat(reward.getTotalPrize()).isEqualTo(Rank.valueOf(matchingCount, false).getWinningMoney());
    }

}
