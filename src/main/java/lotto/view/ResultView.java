package lotto.view;

import lotto.model.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final static String RESULT_MESSAGE = "당첨 통계.\n------";
    private final static List<Rank> rankList = Arrays.stream(Rank.values())
                                                    .sorted(Comparator.comparing(Rank::getWinningMoney))
                                                    .filter(r -> r.getCountOfMatch() >= 3)
                                                    .collect(Collectors.toList());

    public void displayLottoNumbers(List<LottoNumber> lottoNumberList){
        StringBuilder uiBuilder = new StringBuilder();
        for (LottoNumber lottoNumber : lottoNumberList) {
            uiBuilder.append(lottoNumber.getLottoNumber() + "\n");
        }
        System.out.println(uiBuilder.toString());
    }

    public void displayResult(LottoResult lottoResult) {
        System.out.println(RESULT_MESSAGE);

        for (Rank rank : rankList) {
            int count = lottoResult.getWinnerCount(rank.getRewardStatus());
            System.out.println(displayLottoRank(rank.getRewardStatus(), count));
        }
    }

    public void displayResultRateMessage(float profitRate) {
        System.out.println("총 수익률은 " + getProfit(profitRate) + "입니다." + getProfitRateMessage(profitRate));
    }

    private String displayLottoRank (RewardStatus rewardStatus, int count) {
        return Rank.find(rewardStatus).getCountOfMatch()
                + "개 일치 "
                + ((rewardStatus.isMatchingBonus()) ? ", 보너스볼 일치" : "")
                + "(" + Rank.find(rewardStatus).getWinningMoney() + ") - " +count + "개";
    }

    private String getProfit(float profitRate) {
        return String.format("%.02f", profitRate);
    }

    private String getProfitRateMessage(float profitRate){
        if (profitRate == 1) {
            return "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
        }
        if (profitRate < 1) {
            return "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)";
    }

}