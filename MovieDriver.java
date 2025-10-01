import java.util.Scanner;

public class MovieDriver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Movie pic1 = new Movie();
		boolean next = false;
		
		do {
			System.out.println("Enter the title of a movie");
			pic1.setTitle(in.nextLine());
			System.out.println("Enter the rating for the movie");
			pic1.setRating(in.nextLine());
			System.out.println("Enter the number of tickects sold");
			pic1.setSoldTickets(in.nextInt());
			System.out.println(pic1.toString());
			System.out.println("Do you want to enter another? (y or n):");
			if(in.next().equals("y")) {
				next = true;
			}
			in.nextLine();
		} while (next == true);
		
		in.close();
		System.exit(0);
	}
}
