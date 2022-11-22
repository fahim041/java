package core;

public class TaxReport {
    private TaxCalculator calculator;

    public TaxReport(TaxCalculator calculator){
//        calculator = new TaxCalculator(100_000);
        this.calculator = calculator;
    }

    public void show(){
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }
}
