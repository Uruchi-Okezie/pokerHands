package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class HandValue {
    public Rank playerHand(List<Card> hand) {
        Collections.sort(hand);
        if (isRoyalFlush(hand)) {
            return Rank.ROYAL_FLUSH;
        } else if (isStraightFlush(hand)) {
            return Rank.STRAIGHT_FLUSH;
        } else if (isFourOfAKind(hand)) {
            return Rank.FOUR_OF_A_KIND;
        } else if (isFullHouse(hand)) {
            return Rank.FULL_HOUSE;
        } else if (isFlush(hand)) {
            return Rank.FLUSH;
        } else if (isStraight(hand)) {
            return Rank.STRAIGHT;
        } else if (isThreeOfAKind(hand)) {
            return Rank.THREE_OF_A_KIND;
        } else if (isTwoPair(hand)) {
            return Rank.TWO_PAIR;
        } else if (isPair(hand)) {
            return Rank.PAIR;
        } else {
            return Rank.HIGH_CARD;
        }
    }

    private Map<Integer, Integer> getValueCounts(List<Card> hand) {
        Map<Integer, Integer> valueCounts = new HashMap<>();
        for (Card card : hand) {
            valueCounts.merge(card.getValue(), 1, Integer::sum);
        }
        return valueCounts;
    }

    public boolean isRoyalFlush(List<Card> hand) {
        if (!isFlush(hand)) return false;
        if (!isStraight(hand)) return false;
        return hand.get(4).getValue() == 14 && hand.get(0).getValue() == 10;
    }

    public boolean isStraightFlush(List<Card> hand) {
        return isFlush(hand) && isStraight(hand);
    }

    public boolean isFourOfAKind(List<Card> hand) {
        Map<Integer, Integer> valueCounts = getValueCounts(hand);
        return valueCounts.containsValue(4);
    }

    public boolean isFullHouse(List<Card> hand) {
        Map<Integer, Integer> valueCounts = getValueCounts(hand);
        return valueCounts.containsValue(3) && valueCounts.containsValue(2);
    }

    public boolean isFlush(List<Card> hand) {
        String firstSuit = hand.get(0).getSuit();
        return hand.stream().allMatch(card -> card.getSuit().equals(firstSuit));
    }

    public boolean isStraight(List<Card> hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i + 1).getValue() - hand.get(i).getValue() != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isThreeOfAKind(List<Card> hand) {
        Map<Integer, Integer> valueCounts = getValueCounts(hand);
        return valueCounts.containsValue(3);
    }

    public boolean isTwoPair(List<Card> hand) {
        Map<Integer, Integer> valueCounts = getValueCounts(hand);
        return valueCounts.values().stream().filter(count -> count == 2).count() == 2;
    }

    public boolean isPair(List<Card> hand) {
        Map<Integer, Integer> valueCounts = getValueCounts(hand);
        return valueCounts.containsValue(2);
    }

    public int highestCardProcessing(List<Card> player1Hand, List<Card> player2Hand) {
        // Create copies and sort them
        List<Card> p1Sorted = new ArrayList<>(player1Hand);
        List<Card> p2Sorted = new ArrayList<>(player2Hand);
        Collections.sort(p1Sorted);  // Sort in ascending order
        Collections.sort(p2Sorted);

        Rank p1Rank = playerHand(p1Sorted);
        Rank p2Rank = playerHand(p2Sorted);

        if (p1Rank != p2Rank) {
            return p1Rank.getValue() > p2Rank.getValue() ? 1 : 2;
        }

        switch (p1Rank) {
            case FOUR_OF_A_KIND -> {
                int p1FourValue = getFourOfAKindValue(p1Sorted);
                int p2FourValue = getFourOfAKindValue(p2Sorted);
                if (p1FourValue != p2FourValue) {
                    return p1FourValue > p2FourValue ? 1 : 2;
                }
                int p1Kicker = getKicker(p1Sorted, p1FourValue);
                int p2Kicker = getKicker(p2Sorted, p2FourValue);
                if (p1Kicker != p2Kicker) {
                    return p1Kicker > p2Kicker ? 1 : 2;
                }
            }
            case FULL_HOUSE -> {
                int p1ThreeValue = getThreeOfAKindValue(p1Sorted);
                int p2ThreeValue = getThreeOfAKindValue(p2Sorted);
                if (p1ThreeValue != p2ThreeValue) {
                    return p1ThreeValue > p2ThreeValue ? 1 : 2;
                }
                int p1PairValue = getPairValue(p1Sorted, p1ThreeValue);
                int p2PairValue = getPairValue(p2Sorted, p2ThreeValue);
                if (p1PairValue != p2PairValue) {
                    return p1PairValue > p2PairValue ? 1 : 2;
                }
            }
            case THREE_OF_A_KIND -> {
                int p1ThreeValue = getThreeOfAKindValue(p1Sorted);
                int p2ThreeValue = getThreeOfAKindValue(p2Sorted);
                if (p1ThreeValue != p2ThreeValue) {
                    return p1ThreeValue > p2ThreeValue ? 1 : 2;
                }
                List<Integer> p1Kickers = getKickersForThreeOfAKind(p1Sorted, p1ThreeValue);
                List<Integer> p2Kickers = getKickersForThreeOfAKind(p2Sorted, p2ThreeValue);
                for (int i = 0; i < p1Kickers.size(); i++) {
                    if (!p1Kickers.get(i).equals(p2Kickers.get(i))) {
                        return p1Kickers.get(i) > p2Kickers.get(i) ? 1 : 2;
                    }
                }
            }
            case TWO_PAIR -> {
                List<Integer> p1Pairs = getTwoPairValues(p1Sorted);
                List<Integer> p2Pairs = getTwoPairValues(p2Sorted);
                if (!p1Pairs.get(1).equals(p2Pairs.get(1))) {
                    return p1Pairs.get(1) > p2Pairs.get(1) ? 1 : 2;
                }
                if (!p1Pairs.get(0).equals(p2Pairs.get(0))) {
                    return p1Pairs.get(0) > p2Pairs.get(0) ? 1 : 2;
                }
                int p1Kicker = getKickerInTwoPair(p1Sorted, p1Pairs);
                int p2Kicker = getKickerInTwoPair(p2Sorted, p2Pairs);
                if (p1Kicker != p2Kicker) {
                    return p1Kicker > p2Kicker ? 1 : 2;
                }
            }
            case PAIR -> {
                int p1PairValue = getPairValue(p1Sorted, 0);
                int p2PairValue = getPairValue(p2Sorted, 0);
                if (p1PairValue != p2PairValue) {
                    return p1PairValue > p2PairValue ? 1 : 2;
                }
                List<Integer> p1Kickers = getKickersForPair(p1Sorted, p1PairValue);
                List<Integer> p2Kickers = getKickersForPair(p2Sorted, p2PairValue);
                for (int i = 0; i < p1Kickers.size(); i++) {
                    if (!p1Kickers.get(i).equals(p2Kickers.get(i))) {
                        return p1Kickers.get(i) > p2Kickers.get(i) ? 1 : 2;
                    }
                }
            }
        }

        if (p1Rank == Rank.HIGH_CARD || p1Rank == Rank.FLUSH || p1Rank == Rank.STRAIGHT || p1Rank == Rank.STRAIGHT_FLUSH) {
            // Compare each card from highest to lowest
            for (int i = 4; i >= 0; i--) {  // Starting from the highest card
                int p1Value = p1Sorted.get(i).getValue();
                int p2Value = p2Sorted.get(i).getValue();
                if (p1Value != p2Value) {
                    return p1Value > p2Value ? 1 : 2;
                }
            }
        }
        return 0;
    }

    private int getFourOfAKindValue(List<Card> hand) {
        return getValueCounts(hand).entrySet().stream()
                .filter(e -> e.getValue() == 4)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }

    private int getThreeOfAKindValue(List<Card> hand) {
        return getValueCounts(hand).entrySet().stream()
                .filter(e -> e.getValue() == 3)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }

    private int getKicker(List<Card> hand, int excludeValue) {
        return hand.stream()
                .mapToInt(Card::getValue)
                .filter(v -> v != excludeValue)
                .findFirst()
                .orElse(0);
    }

    private List<Integer> getKickersForThreeOfAKind(List<Card> hand, int threeOfAKindValue) {
        return hand.stream()
                .mapToInt(Card::getValue)
                .filter(v -> v != threeOfAKindValue)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    private int getPairValue(List<Card> hand, int excludeValue) {
        return getValueCounts(hand).entrySet().stream()
                .filter(e -> e.getValue() == 2 && e.getKey() != excludeValue)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }

    private List<Integer> getTwoPairValues(List<Card> hand) {
        return getValueCounts(hand).entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

    private int getKickerInTwoPair(List<Card> hand, List<Integer> pairValues) {
        return hand.stream()
                .mapToInt(Card::getValue)
                .filter(v -> !pairValues.contains(v))
                .findFirst()
                .orElse(0);
    }

    private List<Integer> getKickersForPair(List<Card> hand, int pairValue) {
        return hand.stream()
                .mapToInt(Card::getValue)
                .filter(v -> v != pairValue)
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }
}