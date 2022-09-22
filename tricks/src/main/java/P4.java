/*
 * Copyright (c) 2022. pineapple-man
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author pineapple-man
 * @version 1.0
 * @date 2022/9/21 15:07
 */

public class P4 {
	public static int solution(int[][] arr) {
		PriorityQueue<Node> heap =
				new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
		int n = arr.length;
		int m = arr[0].length;
		boolean[][] visited = new boolean[n][m];
		int threshold = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (!visited[i][0]) {
				heap.add(new Node(arr[i][0], i, 0));
				visited[i][0] = true;
				threshold = Math.min(threshold, arr[i][0]);
			}
			if (!visited[i][m - 1]) {
				heap.add(new Node(arr[i][m - 1], i, m - 1));
				visited[i][m - 1] = true;
				threshold = Math.min(threshold, arr[i][m - 1]);
			}
		}
		for (int i = 0; i < m; i++) {
			if (!visited[0][i]) {
				heap.add(new Node(arr[0][i], 0, i));
				visited[0][i] = true;
				threshold = Math.min(threshold, arr[0][i]);
			}
			if (!visited[n - 1][i]) {
				heap.add(new Node(arr[n - 1][i], n - 1, i));
				visited[n - 1][i] = true;
				threshold = Math.min(threshold, arr[n - 1][i]);
			}
		}
		int water = 0;
		while (!heap.isEmpty()) {
			Node head = heap.poll();
			// put the up
			if (head.row - 1 > 0 && !visited[head.row - 1][head.col]) {
				visited[head.row - 1][head.col] = true;
				heap.add(new Node(arr[head.row - 1][head.col], head.row - 1,
						head.col));
				threshold = Math.max(threshold, head.value);
			}
			// put the down
			if (head.row + 1 < n && !visited[head.row + 1][head.col]) {
				visited[head.row + 1][head.col] = true;
				heap.add(new Node(arr[head.row + 1][head.col], head.row + 1,
						head.col));
				threshold = Math.max(threshold, head.value);
			}
			// put the left
			if (head.col - 1 > 0 && !visited[head.row][head.col - 1]) {
				visited[head.row][head.col - 1] = true;
				heap.add(new Node(arr[head.row][head.col - 1], head.row,
						head.col - 1));
				threshold = Math.max(threshold, head.value);
			}
			// put the right
			if (head.col + 1 < m && !visited[head.row][head.col + 1]) {
				visited[head.row][head.col + 1] = true;
				heap.add(new Node(arr[head.row][head.col + 1], head.row,
						head.col + 1));
				threshold = Math.max(threshold, head.value);
			}
			water += Math.max(0, threshold - head.value);
		}
		return water;
	}
	
	static class Node {
		int value;
		int row;
		int col;
		
		public Node(int value, int row, int col) {
			this.value = value;
			this.row = row;
			this.col = col;
		}
	}
}
