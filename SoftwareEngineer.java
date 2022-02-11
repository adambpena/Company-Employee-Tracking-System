class SoftwareEngineer extends Employee
{
    SoftwareEngineer(String engrName, double engrSalary)
    {
        this.name = engrName;
        this.salary = engrSalary;
        this.cash = 0;
    }
    
    public void giveRaise(double percentage)
    {
        this.salary = (salary * (percentage * .01)) + salary;
    }
    
    public double getCash()
    {
        return cash;
    }
}

