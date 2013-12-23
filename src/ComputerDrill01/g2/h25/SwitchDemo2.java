package ComputerDrill01.g2.h25;

public class SwitchDemo2 {

	public static void main(String[] args) {

		for (int i = 0; i < args.length; i++) {

			int num = Integer.parseInt(args[i]);
			switch (num) {
			case 1:
				System.out.println("A");
				break;
			case 2:
			case 3:
				System.out.println("B");
				break;
			case 4:
				System.out.println("C");
				break;
			case 5:
				System.out.println("D");
				break;
			default:
				System.out.println("BAD NUMBER");
			}
		}
	}
}
