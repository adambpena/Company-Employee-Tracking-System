import java.util.Scanner;


public class Main
{
    static Employee[] empArray = new Employee[5];
    static Employee[] hourlyEmpArray = new Employee[5];
    
    public static String menuLoad()
    {
        String menu = "What would you like to do?\na.  Add an Employee\nb.  List all Employees\nc.  Give an Employee a raise\nd.  Give Paychecks\ne.  Change someone's hours\nf. quit";
        System.out.println(menu);
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String invalid = "That is not a valid option, try again";
        String returns;

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
            String theInput;
            theInput = Main.menuLoad();
            switch(theInput)
            {
                case a:
                case A:
            }
        }
	}
}
