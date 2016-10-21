import java.util.Scanner;

public class MultiStringcollClient {
	public static final String SENTINEL = "###";

	public static void main(String[] args)
	{
		String value; Scanner keyboard = new Scanner(System.in);
		MultiStringcoll P=new MultiStringcoll();

		System.out.println("Enter an String to be inserted or ### to quit:");
		value=keyboard.nextLine();
		while(!value.equals(SENTINEL)){
			{
				P.insert(value);
				System.out.println("Enter next String to be inserted or ### to quit:");
				value=keyboard.nextLine();
			}
		}
		System.out.println("\nThe values in collection P are:");
		P.print();
	}
}