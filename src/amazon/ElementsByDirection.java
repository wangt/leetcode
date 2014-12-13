package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElementsByDirection {

	public Node[][] readNodesFromStdin() {

		Scanner scanner = new Scanner(System.in);

		int cols = scanner.nextInt();

		int rows = scanner.nextInt();

		Node[][] metrics = new Node[rows][cols];

		for (int row = 0; row < rows; row++) {

			for (int col = 0; col < cols; col++) {

				metrics[row][col] = new Node(scanner.nextInt());

			}

		}

		scanner.close();

		return metrics;
	}

	private void visit(List<Node> nodes, Node node) {
		node.visisted = true;
		nodes.add(node);
	}

	public List<Node> move(Node[][] matrix, Direction... directions) {

		List<Node> nodes = new ArrayList<Node>();

		int currentRow = 0;
		int currentCol = 0;

		visit(nodes, matrix[currentRow][currentCol]);

		for (Direction direction : directions) {

			while (true) {

				int nextRow = currentRow;
				int nextCol = currentCol;

				if (Direction.LEFT.equals(direction)) {
					nextCol--;
				} else if (Direction.RIGHT.equals(direction)) {
					nextCol++;
				} else if (Direction.LEFT_DOWN.equals(direction)) {
					nextCol--;
					nextRow++;
				} else if (Direction.UP.equals(direction)) {
					nextRow--;
				}

				// Check whether next position exceed border limit
				if (nextCol >= matrix[0].length || nextCol < 0
						|| nextRow >= matrix.length || nextRow < 0) {
					System.out.println("Hit borders");
					break;
				}

				// check whether next node has been visited

				Node nextNode = matrix[nextRow][nextCol];

				if (nextNode.visisted) {
					break;
				}

				currentRow = nextRow;
				currentCol = nextCol;
				nextNode.visisted = true;
				nodes.add(nextNode);

				System.out.println("Row:" + nextRow + ", Col:" + nextCol);

			}

		}

		return nodes;

	}

	public void move() {

		Node[][] matrix = readNodesFromStdin();

		List<Node> nodes = move(matrix, Direction.RIGHT, Direction.LEFT_DOWN,
				Direction.LEFT, Direction.UP);

		for (Node node : nodes) {
			System.out.print(node.d + " ");
		}

	}

	private enum Direction {
		RIGHT, LEFT, LEFT_DOWN, UP
	}

	private static class Node {

		int d;

		boolean visisted;

		Node(int d) {
			this.d = d;
			this.visisted = false;
		}

	}

	public static void main(String[] args) {

		ElementsByDirection ed = new ElementsByDirection();

		ed.move();

	}

}
