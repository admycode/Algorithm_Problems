//Detect if there is odd cycle in an undirected graph. We can do this easily by maintaining 2-color information while doing 
//a DFS search. Every new node gets the opposite color of its predecessor. Then any non-tree edge with both endpoints with
//the same color will prove the existance of an odd cycle.

import java.util.*;
import java.io.*;

class Graph{
	LinkedList<Integer> adj[];	//adjacency list representation
	int V;	//number of vertices in the graph
	boolean oddCycle;
	int[] color;

	Graph(int v){
		this.V = v;
		adj = new LinkedList[v];
		for(int i=0; i < v; i++){
			adj[i] = new LinkedList<Integer>();
		}
		color = new int[v];
		Arrays.fill(color, 0);
	}

	void addEdge(int u, int v){
		adj[u].add(v);
		adj[v].add(u);
	}

	boolean hasOddCycle(){
		return oddCycle;
	}

	void dfs(int u, int vcolor){

		if(color[u] != 0){
			if(color[u] != vcolor){
				oddCycle = true;
			}
			return;
		}

		color[u] = vcolor;	//mark vertex with designated color

		for(int v : adj[u]){
			dfs(v, 3-vcolor);	//call dfs with alternate color to paint adjacent vertices with different colors
		}
	}

	void detectOddCycle(){
		
		for(int i=0; i < V; i++){
			if(color[i] == 0)	//dfs on every unvisited vertices
				dfs(i,1);
		}
		
	}
}

public class OddCycle{

	public static void main(String[] args){

		Graph g = new Graph(5);

		g.addEdge(0,4);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(0,3);
		g.addEdge(1,3);

		g.detectOddCycle();

		System.out.println("Graph has odd cycle: " + g.hasOddCycle());
	}
} 
