package week1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnnualIncomeTaxCalculatorProgram {

    final static List<IncomeTaxRate> incomeTaxRateTable;

    static {
        incomeTaxRateTable = new ArrayList<>();
        int suffix = 1_000_000;
        incomeTaxRateTable.add(new IncomeTaxRate(new BigDecimal(0), null, null));
        incomeTaxRateTable.add(new IncomeTaxRate(new BigDecimal(12*suffix), new BigDecimal(0.06), new BigDecimal(0)));
        incomeTaxRateTable.add(new IncomeTaxRate(new BigDecimal(46*suffix), new BigDecimal(0.15), new BigDecimal(1.08*suffix)));
        incomeTaxRateTable.add(new IncomeTaxRate(new BigDecimal(88*suffix), new BigDecimal(0.24), new BigDecimal(5.22*suffix)));
        incomeTaxRateTable.add(new IncomeTaxRate(new BigDecimal(150*suffix), new BigDecimal(0.35), new BigDecimal(14.9*suffix)));
        incomeTaxRateTable.add(new IncomeTaxRate(new BigDecimal(300*suffix), new BigDecimal(0.38), new BigDecimal(19.4*suffix)));
        incomeTaxRateTable.add(new IncomeTaxRate(new BigDecimal(500*suffix), new BigDecimal(0.40), new BigDecimal(25.4*suffix)));
        incomeTaxRateTable.add(new IncomeTaxRate(new BigDecimal(1000*suffix), new BigDecimal(0.42), new BigDecimal(35.4*suffix)));
        incomeTaxRateTable.add(new IncomeTaxRate(null, new BigDecimal(0.45), new BigDecimal(65.4*suffix)));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BigDecimal myAnnualIncome;

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.: ");
        myAnnualIncome = sc.nextBigDecimal();
        BigDecimal[] result = calculateTax(myAnnualIncome);

        System.out.printf("\n%s\t\t %11s", "[세율에 의한 세금]:", result[0]);
        if (result[1] != null)
            System.out.printf("\n%s %11s", "[누진공제 계산 의한 세금]:", result[1]);

        sc.close();
    }

    private static BigDecimal[] calculateTax(BigDecimal income) {
        BigDecimal taxByTaxRate= BigDecimal.ZERO;
        BigDecimal taxByProgressiveDeduction = null;

        IncomeTaxRate cur, prev;

        for (int i = 1; i < incomeTaxRateTable.size(); i++) {
            cur = incomeTaxRateTable.get(i);
            prev = incomeTaxRateTable.get(i - 1);

            // 내 소득이 현재 과세표준보다 크고 1_000_000_000 초과가 아닌 경우
            if (cur.getTaxableIncome() != null && income.compareTo(cur.getTaxableIncome()) > 0) {
                taxByTaxRate = taxByTaxRate.add(intermediateTax(cur.getTaxableIncome().subtract(prev.getTaxableIncome()), cur.getTaxRate()));

            } else {
                taxByTaxRate = taxByTaxRate.add(intermediateTax(income.subtract(prev.getTaxableIncome()), cur.getTaxRate()));

                // 누진공제계산
                if (income.compareTo(incomeTaxRateTable.get(1).getTaxableIncome()) > 0) {
                    taxByProgressiveDeduction = income.multiply(cur.getTaxRate()).subtract(cur.getProgressiveDeduction());
                }
                break;
            }
        }
        return new BigDecimal[]{roundBigDecimal(taxByTaxRate), roundBigDecimal(taxByProgressiveDeduction)};
    }

    private static BigDecimal roundBigDecimal(BigDecimal value) {
        if (value != null)
            return value.setScale(0, BigDecimal.ROUND_HALF_UP);
        return null;
    }

    private static BigDecimal intermediateTax(BigDecimal income, BigDecimal taxRate) {
        BigDecimal tax = income.multiply(taxRate);
        System.out.printf("%11s * %2s%% = %11s\n",
                roundBigDecimal(income), roundBigDecimal(taxRate.multiply(new BigDecimal(100))), roundBigDecimal(tax));
        return tax;
    }
}


class IncomeTaxRate {
    private BigDecimal taxableIncome;
    private BigDecimal taxRate;
    private BigDecimal progressiveDeduction;

    public IncomeTaxRate(BigDecimal taxableIncome, BigDecimal taxRate, BigDecimal progressiveDeduction) {
        this.taxableIncome = taxableIncome;
        this.taxRate = taxRate;
        this.progressiveDeduction = progressiveDeduction;
    }

    public BigDecimal getTaxableIncome() {
        return taxableIncome;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public BigDecimal getProgressiveDeduction() {
        return progressiveDeduction;
    }
}
