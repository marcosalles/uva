import java.util.Scanner;

public class Main539 {

	private static boolean cityMap[][];
	private static int longestPath;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()) {
			int settlements = sc.nextInt();
			int roads = sc.nextInt();
			if(settlements == 0 && roads == 0) break;
			cityMap = new boolean[25][25];
			for (int e = 0; e < roads; e++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				cityMap[x][y] = true;
				cityMap[y][x] = true;
			}
			findShortestPathFor(settlements);
			System.out.println(longestPath);
		}
	}

	private static void findShortestPathFor(int settlements) {
		longestPath = 0;
		for (int currentSettlement = 0; currentSettlement < settlements; currentSettlement++) {
			findPathFor(currentSettlement, settlements, 0);
		}
	}

	private static void findPathFor (int currentSettlement, int settlements, int currentPathLength) {
		if(currentPathLength > longestPath) {
			longestPath = currentPathLength;
		}

		for(int nextSettlement = 0; nextSettlement < settlements; nextSettlement++) {
			if(cityMap[currentSettlement][nextSettlement]) {

				cityMap[currentSettlement][nextSettlement] = false;
				cityMap[nextSettlement][currentSettlement] = false;

				findPathFor(nextSettlement, settlements, currentPathLength+1);

				cityMap[currentSettlement][nextSettlement] = true;
				cityMap[nextSettlement][currentSettlement] = true;
			}
		}
	}
}