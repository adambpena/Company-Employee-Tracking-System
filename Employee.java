abstract class Employee
{
    protected String name;
    protected double salary;
    protected double cash;
    
    public double getCash()
    {
        return cash;
    }
    
    public void getPaid(double paycheck)
    {
        cash += paycheck;
    }
    
    public abstract void giveRaise(double percentage);
    
}