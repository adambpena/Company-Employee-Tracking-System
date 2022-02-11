class AdministrativeAssistant extends Employee implements Hourly
{
    public int hoursPerWeek;
    
    AdministrativeAssistant(String adminName, double adminSalary, int adminHour)
    {
        this.name = adminName;
        this.salary = adminSalary;
        this.hoursPerWeek = adminHour;
    }
    
    public int getNumOfHours()
    {
        return this.hoursPerWeek;
    }
    
    public void setHours(int newHours)
    {
        this.hoursPerWeek = newHours;
    }
    
    public void giveRaise(double increase)
    {
        this.salary += increase;
    }
    
    public double getPaid(double paycheck)
    {
        this.cash += (hoursPerWeek * 2) * salary;
    }
    
}