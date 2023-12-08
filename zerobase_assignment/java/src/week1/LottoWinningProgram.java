package week1;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWinningProgram {
    private final int[] winningLotto;

    public LottoWinningProgram() {
        this.winningLotto = LottoCreation.createRandomLotto();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LottoWinningProgram program = new LottoWinningProgram();
        MyLotto myLotto;

        try {
            System.out.println("[로또 당첨 프로그램]");
            System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10): ");

            int lottoNum = sc.nextInt();
            myLotto = new MyLotto(lottoNum);
            myLotto.printMyLotto();

            System.out.println("\n[로또 발표]");
            program.printWinningNumbers();

            System.out.println("\n[내 로또 결과]");
            myLotto.printMyLottoResult(program.winningLotto);

        } catch (InputMismatchException e) {
            System.out.println("숫자를 잘못 입력하셨습니다. 프로그램을 종료 합니다.");
        }
    }

    private void printWinningNumbers() {
        System.out.println(LottoNumberFormatter.format(this.winningLotto));
    }
}



class MyLotto {
    private int lottoNum;
    private Map<Character, int[]> lotto;

    public MyLotto(int lottoNum) {
        this.lottoNum = lottoNum;
        this.lotto = new HashMap<>(lottoNum);
    }

    public void printMyLotto() {
        for (int i = 0; i < lottoNum; i++) {
            lotto.put((char) ('A' + i), LottoCreation.createRandomLotto());
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, int[]> map : this.lotto.entrySet()) {
            sb.append(LottoNumberFormatter.format(map.getKey(), map.getValue()));
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public void printMyLottoResult(int[] winningNumbers) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, int[]> map : this.lotto.entrySet()) {
            sb.append(LottoNumberFormatter.format(map.getKey(), map.getValue()));
            sb.append(String.format(" => %d개 일치", matchNumbers(winningNumbers, map.getValue())));
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private int matchNumbers(int[] a, int[] b) {
        int len = a.length;
        int count = 0;
        int i = 0, j = 0;

        while (i < len && j < len) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
}


class LottoCreation {
    private final static int LOTTO_LEN = 6;
    private final static int LOTTO_BOUND = 45;
    private final static Random rand = new Random();

    public static int[] createRandomLotto() {
        Set<Integer> set = new HashSet<>(LOTTO_LEN);

        int count = 0;
        while (count < LOTTO_LEN) {
            int randInt = rand.nextInt(1, LOTTO_BOUND);
            if (set.add(randInt)) count++;
        }

        int[] result = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);

        return result;
    }
}

class LottoNumberFormatter {
    public static String format(int[] numbers) {
        return String.format("%s\t", "") +
                Arrays.stream(numbers)
                        .mapToObj(n -> String.format("%02d", n))
                        .collect(Collectors.joining(", "));
    }
    public static String format(Character key, int[] numbers) {
        return String.format("%s\t", key) +
                Arrays.stream(numbers)
                        .mapToObj(n -> String.format("%02d", n))
                        .collect(Collectors.joining(", "));
    }
}