//This program finds if there is any cycle in the directed graph using DFS

import java.util.*;
import java.io.*;

//This class represents an directed graph in adjacency list format, and method for finding cycle
class Graph {
	private int V;
	private LinkedList<Integer> adj[];
	int time = 0;
	static final int WHITE = 1;
	static final int GREY = 2;
	static final int BLACK = 3;

	//constructor
	Graph(int v){
		this.V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++){
			adj[i] = new LinkedList();
		}
	}
	
	//Function to add an edge to the graph
	void addEdge(int u, int v){
		adj[u].add(v);
	}

	int V(){
		return V;
	}

	LinkedList<Integer> get(int i){
		return adj[i];
	}

	void print(){
		for(int i=0; i<V; i++){
			System.out.print(i + ":");
			for(int j : adj[i]){
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	//recursive DFS algorithm for finding cycle.
	//Note that, there will be a cycle if back edge is found while doing DFS
	boolean DFSUtil(int u, int[] color){

		color[u] = GREY;	//vertex being processed

		for(int v : adj[u]){
			if(color[v] == GREY)	//backedge
				return true;
			if(color[v] == WHITE && DFSUtil(v,color))	//there is backedge in DFS tree rooted at v
				return true;
		}
		color[u] = BLACK;	//u has been processed, i.e, DFS tree of u has been explored fully
		return false;
	}

	boolean hasCycle(){
		int[] color = new int[V];
		Arrays.fill(color, WHITE);

		for(int i=0; i<V; i++){
			if(DFSUtil(i,color))
				return true;
		}
		return false;
	}
	
	
}
public class DirectedCycle{
	
	public static void main(String[] args){
		Graph g1 = new Graph(4);
		g1.addEdge(0,1);
		g1.addEdge(0,2);
		g1.addEdge(1,2);
		g1.addEdge(2,0);
		g1.addEdge(2,3);
		g1.addEdge(3,3);
		System.out.println("The input graph:");
		g1.print();
		if(g1.hasCycle())
			System.out.println("The graph contains cycle");
		else
			System.out.println("The graph does not contain cycle");
	}
}
