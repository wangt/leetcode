package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Climber {

	public List<Mountain> readMoutains() {

		Scanner scanner = new Scanner(System.in);

		scanner.useDelimiter(",|\n");

		List<Mountain> mountains = new ArrayList<Mountain>();

		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {

			Mountain m = new Mountain(scanner.nextInt(), scanner.nextInt(),
					scanner.nextInt());

			mountains.add(m);

		}

		scanner.close();

		return mountains;

	}

	public int walk() {

		Set<Mountain> mountains = new HashSet<Mountain>(readMoutains());

		int distance = 0;

		int pos = 0, height = 0;

		while (true) {

			Iterator<Mountain> iterator = mountains.iterator();

			int maxHeight = 0;

			while (iterator.hasNext()) {

				Mountain m = iterator.next();

				if (m.isClimbed(pos)) {
					iterator.remove();
				} else if (m.isOnCurMoutain(pos)) {

					if (m.height > maxHeight) {
						maxHeight = m.height;
					}
				}

			}

			int heightChange = Math.abs(maxHeight - height);

			height = maxHeight;

			distance += heightChange;

			if (mountains.isEmpty()) {
				distance--;
				break;
			}

			pos++;

			distance++;

		}

		return distance;

	}

	private static class Mountain {

		private int startPos;

		private int endPos;

		private int height;

		public Mountain(int startPos, int endPos, int height) {
			this.startPos = startPos;
			this.endPos = endPos;
			this.height = height;
		}

		public boolean isOnCurMoutain(int pos) {
			return pos <= endPos && pos >= startPos;
		}

		public boolean isClimbed(int pos) {
			return pos > endPos;
		}

		@Override
		public String toString() {
			return "Mountain [startPos=" + startPos + ", endPos=" + endPos
					+ ", height=" + height + "]";
		}

	}

	public static void main(String[] args) {

		Climber climber = new Climber();

		System.out.println(climber.walk());

	}

}
