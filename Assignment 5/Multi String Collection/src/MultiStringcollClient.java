import java.util.Scanner;

public class MultiStringcollClient {
	public static final String SENTINEL = "###";

	public static void main(String[] args)
	{
		String value; Scanner keyboard = new Scanner(System.in);
		MultiStringcoll P = new MultiStringcoll();
		MultiStringcoll N = new MultiStringcoll();
		MultiStringcoll L = new MultiStringcoll();

		System.out.println("Enter an String to be inserted or ### to quit:");
		value=keyboard.nextLine();
		
		while(!value.equals(SENTINEL)){
			{
				if(value.substring(0,1).equals("+")){
					P.insert(value.substring(1));
					L.insert(value.substring(1));
				}
				else if (value.substring(0,1).equals("-")){
					N.insert(value.substring(1));
					L.omit(value.substring(1));
				}
				System.out.println("Enter next String to be inserted or ### to quit:");
				value=keyboard.nextLine();
			}
		}
		System.out.println("\nThe values in collection P are:");
		P.print();
		System.out.println("\nThe values in collection N are:");
		N.print();
		System.out.println("\nThe values in collection L are:");
		L.print();
		if (P.equals(N)) System.out.println("\nP and N are equal.");
		else System.out.println("\nP and N are NOT equal.");
		MultiStringcoll A=new MultiStringcoll(); A.copy(L);
		System.out.println("\nThe values in the copy of L are:\n");
		A.print();
	}
}