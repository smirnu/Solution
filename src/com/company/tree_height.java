package com.company;

import java.util.*;
import java.io.*;

class Nodes {
	ArrayList<Integer> listNodes;

	Nodes(int val) {
		listNodes = new ArrayList<>();
		listNodes.add(val);
	}

	Nodes(Nodes existed, int val) {
		listNodes = existed.listNodes;
		listNodes.add(val);
	}
}

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
                        // Replace this code with a faster implementation
			int maxHeight = 0;
			Nodes[] tree = new Nodes[n];
			LinkedList<Integer> queue = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				if (parent[i] == -1) {
					queue.add(i);
					continue;
				}
				if (tree[parent[i]] == null) tree[parent[i]] = new Nodes(i);
				else tree[parent[i]] = new Nodes(tree[parent[i]], i);
			}
			int curSize = 1;

			while (!queue.isEmpty()) {
				int node = queue.remove(0);
				if (tree[node] != null) {
					ArrayList<Integer> tmpArray = tree[node].listNodes;

					for (int i = 0; i < tmpArray.size(); i++) {
						queue.add(tmpArray.get(i));
					}
				}
				curSize--;
				if (curSize == 0) {
					maxHeight++;
					curSize = queue.size();
				}

			}
//			for (int vertex = 0; vertex < n; vertex++) {
//				int height = 0;
//				for (int i = vertex; i != -1; i = parent[i])
//					height++;
//				maxHeight = Math.max(maxHeight, height);
//			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
