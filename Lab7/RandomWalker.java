public class RandomWalker {
	public static void main(String[] args) {
		int steps = Integer.parseInt(args[0]);
		int x = 0, y = 0;
		for (int i = 0; i < steps; i++) {
			double rand = Math.random();
			if (rand < 0.25)
				++x;
			else if (rand < 0.5)
				--y;
			else if (rand < 0.75)
				--x;
			else if (rand < 1.0)
				++y;
			System.out.println("(" + x + ", " + y + ")");
		}
		System.out.println("squared distance = " + (x * x + y * y));
	}
}