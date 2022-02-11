//Using subclasses that inherit methods and data from their parent class, Employee(), this program manages a list of up to five salaried or hourly workers. 
//It is a looping menu that continually asks the user for input until the condition that the input equals 'f'
//(the quit option) is met. The list allows employees to be added, paychecks to be doled out, hours to changed for hourly workers, raises to be given to specific workers, and
//a sort of toString to be printed out showing the employees currently hired and information about them.

import java.util.Scanner;
import java.text.NumberFormat;

public class Main
{
    //a number of static variables are instantiated so that they can be referred to from any context within the program later
    static NumberFormat money = NumberFormat.getCurrencyInstance();
    static Scanner in = new Scanner(System.in);
    //two arrays, one holding Employees and another holding AdministrativeAssistants(hourly workers). Hourly workers will be added to both arrays but salaried workers will only be added to empArray.
    //AdministrativeAssistants have hoursPerWeek data and hour methods that cant be accessed from the parent class so this array is useful when hour data/methods must be accessed
    static Employee[] empArray = new Employee[5];
    static AdministrativeAssistant[] hourlyEmpArray = new AdministrativeAssistant[5];
    //a temporary Employee object called luckyYou is used to temporarily store the data of certain employees in an array (empArray[i]) that are targeted by the user's input. It is a sort of temporary employee that can be used when a placeholder is useful.
    static Employee luckyYou;
    static String theInput;
    //skipper is a static int set equal to one so that 
    static int skipper = 1;
    
    public static String menuLoad()
    {
        String menu = "What would you like to do?\na.  Add an Employee\nb.  List all Employees\nc.  Give an Employee a raise\nd.  Give Paychecks\ne.  Change someone's hours\nf. quit";
        System.out.println(menu);
        String input = in.next();
        String returns;
        String invalid = "That is not a valid option, try again";

        if(input.equals("a")||input.equals("A")||input.equals("b")||input.equals("B")||input.equals("c")||input.equals("C")||input.equals("d")||input.equals("D")||input.equals("e")||input.equals("E")||input.equals("f")||input.equals("F"))
        {
            if (input.length()==1)
            {
                returns = input;
            }
            
            else 
            {
                returns = invalid;
            }
        }
            
        else
        {
            returns = invalid;
        }
        return returns;
   }
    
	public static void main(String[] args) 
	{
        while(true)    
        {

            theInput = Main.menuLoad();

            
            if(theInput.equals("a")||theInput.equals("A"))
            {
                int openSlot = 0;
                for(int i=0; i<(empArray.length); i++)
                {
                    if(empArray[i] == null)
                    {
                        openSlot++;
                    }
                    else
                    {;}
                }
                
                String newEmpName;
                double newEmpSalary;
                String empHourlyQ;
                
                if(openSlot >= 1 && openSlot <= 5)
                {
                    System.out.println("What is the employee's name?");
                    in.nextLine();
                    newEmpName = in.nextLine();
                    
                    System.out.println("What is their salary (yearly or hourly)?");
                    while(true)
                    {
                        try
                        {
                            newEmpSalary = in.nextDouble();
                            break;
                        }
                        
                        catch(Exception e)
                        {
                            System.out.println("Must use only numbers to define salary, try again");
                            in.next();
                        }
                    }

                    System.out.println("Are they an hourly worker? (Y/N)");
                    empHourlyQ = in.next();
                    
                    while(true)
                    {
                        if(empHourlyQ.equals("y")||empHourlyQ.equals("Y")||empHourlyQ.equals("n")||empHourlyQ.equals("N"))
                        {
                            break;
                        }
                        
                        else
                        {
                            System.out.println("Invalid entry, use a single letter: Y/N");
                            empHourlyQ = in.next();
                        }
                        
                    }
                    
                    int newEmpHours = 0;
                    
                    if(empHourlyQ.equals("Y")||empHourlyQ.equals("y"))
                    {
                        System.out.println("How many hours does " + newEmpName + " work?");
                        while(true)
                        {
                            try
                            {
                                newEmpHours = in.nextInt();
                                break;
                            }
                            
                            catch(Exception e)
                            {
                                System.out.println("Must use only integers to define hours, try again");
                                in.next();
                            }
                        }
                        
                        AdministrativeAssistant newAA = new AdministrativeAssistant(newEmpName, newEmpSalary, newEmpHours);
                        
                        for(int i=0;i<empArray.length;i++)
                        {
                            if (empArray[i] == null)
                            {
                                empArray[i] = newAA;
                                System.out.println(newEmpName + " has been hired as an administrative assistant!");
                                break;
                            }
                        }
                        
                        for(int i=0;i<hourlyEmpArray.length;i++)
                        {
                            if (hourlyEmpArray[i] == null)
                            {
                                hourlyEmpArray[i] = newAA;
                                break;
                            }
                        }
                    }
                    
                    else
                    {
                       SoftwareEngineer newAA = new SoftwareEngineer(newEmpName, newEmpSalary);
                        
                        for(int i=0;i<empArray.length;i++)
                        {
                            if (empArray[i] == null)
                            {
                                empArray[i] = newAA;
                                System.out.println(newEmpName + " has been hired as a software engineer!");
                                break;
                            }
                        }  
                    }
                }
                else
                {
                    System.out.println("There's no room for a new employee.");
                }
            }
                
            if(theInput.equals("b")||theInput.equals("B"))
            {
               for(int i=0; i<empArray.length;i++)
               {
                   int trackAA = i;
                   if(empArray[i] != null)
                   {
                       if(empArray[i].getClass().toString().equals("class AdministrativeAssistant"))
                       {
                            for(int n=0;n<hourlyEmpArray.length;n++)  
                            {
                                if(empArray[trackAA].equals(hourlyEmpArray[n]))
                                {
                                    System.out.println("Name: " + hourlyEmpArray[n].name + " " + "Salary: " + money.format(hourlyEmpArray[n].salary) + " " + "Cash: " + money.format(hourlyEmpArray[n].getCash()) + " " + "Hours worked per week: " + hourlyEmpArray[n].hoursPerWeek + ", " +  "Administrative Assistant.");
                                }
                            }
                       }
                       
                       else
                       {
                            System.out.println("Name: " + empArray[i].name + " " + "Salary: " + money.format(empArray[i].salary) + " " + "Cash: " + money.format(empArray[i].getCash()) + " "  + "Software Engineer.");
                       }
                   }
               }
            }
            
            if(theInput.equals("c")||theInput.equals("C"))
            {
                System.out.println("Enter the name of the employee who will be receiving a raise:");
                in.nextLine();
                String raiseFor = in.nextLine();
                String thisYou;

                for(int i=0;i<empArray.length;i++)
                {
                    if (empArray[i] != null)
                    {
                        thisYou = empArray[i].name;

                        if(raiseFor.equals(thisYou))
                        {
                            if(empArray[i].getClass().toString().equals("class AdministrativeAssistant"))
                            {
                                luckyYou = empArray[i];
                                System.out.println("How much of a raise will " + empArray[i].name + " get? As an administrative assistant who works by the hour, the number given for the raise will be a flat increase on the employee's hourly rate.");
                                double raiseForEmployee = in.nextDouble();
                                empArray[i].giveRaise(raiseForEmployee);
                                break;
                            }
                            
                            else if (empArray[i].getClass().toString().equals("class SoftwareEngineer"))
                            {
                                luckyYou = empArray[i];
                                System.out.println("How much of a raise will " + empArray[i].name + " get? As a SoftwareEngineer with a salary, the number given for the raise will be a percentage by which the employee's salary is increased.");
                                double raiseForEmployee = in.nextDouble();
                                empArray[i].giveRaise(raiseForEmployee);
                                break;
                            }
                            
                            else if(raiseFor.equals(thisYou) == false && i == empArray.length-1 || empArray[i] == null && i == empArray.length-1)
                            {
                                System.out.println("There is no employee here by that name.");
                                break;
                            }
                            
                            else
                            {;}
                        }
                    }
                    
                    else if(empArray[i] == null && i == empArray.length-1)
                    {
                        System.out.println("That is not the name of a current employee here.");
                        break;
                    }
                }
            }
        
            if(theInput.equals("d")||theInput.equals("D"))
            {
                System.out.println("Every employee currently under employ will now receive a paycheck.");
                
                for(int i=0; i<empArray.length; i++)
                {
                    if(empArray[i] == null)
                    {
                        
                    }
                    
                    else if(empArray[i] != null)
                    {
                        if(empArray[i].getClass().toString().equals("class AdministrativeAssistant"))
                        {
                            Employee hourlyAsParent = empArray[i];
                            AdministrativeAssistant hourlyWorker;
                            for(int n=0;n<hourlyEmpArray.length;n++)
                            {
                                if(hourlyAsParent.equals(hourlyEmpArray[n]))
                                {
                                    hourlyEmpArray[n].getPaid(hourlyEmpArray[n].salary);
                                    hourlyAsParent.cash = hourlyEmpArray[n].cash;
                                }
                            }
                        }
                        
                        else
                        {
                            empArray[i].getPaid(empArray[i].salary);
                        }
                    }
                }
            }
            
            if(theInput.equals("e")||theInput.equals("E"))
            {
                System.out.println("Who's hours would you like to change?");
                in.nextLine();
                String hourChangeEmp = in.nextLine();
                String hourlyEmployeeHere;
                Employee possibleSalariedEmp;
                
                
                if (skipper == 1)
                {
                    for(int i=0;i<empArray.length;i++)
                    {
                        if(empArray[i] != null)
                        {
                            possibleSalariedEmp = empArray[i];
                            String isThisTheGuy = possibleSalariedEmp.name;
                            
                            if(isThisTheGuy.equals(hourChangeEmp))
                            {
                                if(possibleSalariedEmp.getClass().toString().equals("class SoftwareEngineer"))
                                {
                                    System.out.println("That employee is paid an annual salary; no hours to adjust.");
                                    skipper = 0;
                                    break;
                                }
                            }
                        }
                    }
                    
                    skipper++;
                    
                    if (skipper == 2)
                    {
                        for(int i=0;i<hourlyEmpArray.length;i++)
                        {
                            if(hourlyEmpArray[i] != null)
                            {
                                hourlyEmployeeHere = hourlyEmpArray[i].name;
                                
                                if(hourlyEmployeeHere.equals(hourChangeEmp)&& skipper==2 )
                                {
                                    System.out.println("What would you like to change this employee's hours to?");
                                    while(true)
                                    {
                                        try
                                        {
                                            int changedHours = in.nextInt();
                                            hourlyEmpArray[i].setHours(changedHours);
                                            skipper = 0;
                                            break;
                                        }
                                            
                                        catch(Exception e)
                                        {
                                            System.out.println("Must use only integers to define hours, try again");
                                            in.next();
                                        }
                                    }
                                }
                                
                                else if(hourlyEmployeeHere.equals(hourChangeEmp) == false && i == hourlyEmpArray.length-1 || hourlyEmpArray[i] == null && i == hourlyEmpArray.length-1)
                                {
                                    System.out.println("That employee cannot be found.");
                                    break;
                                }
                                
                                else
                                {;}
                            }
                            
                            else if(hourlyEmpArray[i] == null && i == hourlyEmpArray.length-1 && skipper == 2)
                            {
                                System.out.println("There is no employee currently working here under that name.");
                                break;
                            }
                            
                        }
                    }
                }    
                else
                {;}
                skipper = 1;
                    
            }
            
            if(theInput.equals("f")||theInput.equals("F"))
            {
                System.out.println("See you later! Ending program...");
                System.exit(0);
            }
            
            else if(theInput.equals("a") == false && theInput.equals("A") == false && theInput.equals("b") == false && theInput.equals("B") == false && theInput.equals("c") == false && theInput.equals("C") == false && theInput.equals("d") == false && theInput.equals("D") == false && theInput.equals("e") == false && theInput.equals("E") == false && theInput.equals("f") == false && theInput.equals("F") == false)
            {
                System.out.println("That is in an invalid input, please try again");
            }
    	}
    }
}

