// wajp to take input from the user to perfor addition
import java.util.Scanner;
class Addition
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num 1 : ");
		int num1 = sc.nextInt();
		System.out.print("Enter num 2 : ");
		int num2 = sc.nextInt();
		int op = num1+num2;
		System.out.println("Addition is : "+op);
	}
}