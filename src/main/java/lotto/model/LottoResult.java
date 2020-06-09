package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private RankReward rankReward;

    public LottoResult(List<RewardLotto> rewardlottos) {
        this.rankReward = setWinnerResult(rewardlottos);
    }

    private RankReward setWinnerResult(List<RewardLotto> lottoWinerNumbers) {
        return new RankReward(lottoWinerNumbers.stream()
                                .map(i -> Rank.valueOf(i.getMatchingCount(), i.isMatchingBonus()))
                                .collect(Collectors.toList()));
    }

    public RankReward getLottoResult() {
        return this.rankReward;
    }



}
