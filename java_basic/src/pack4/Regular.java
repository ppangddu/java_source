package pack4;

public class Regular extends Ex20Employee {
    private int salary;

    public Regular(String irum, int nai, int salary) {
        super(irum, nai);
        this.salary = salary;
    }

    @Override
    public double pay() {
        return salary;
    }

    @Override
    public void print() {
        display();
        System.out.println(", 급여 : " + pay());
    }
}
