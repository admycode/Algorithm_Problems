import java.util.*;
import java.io.*;

//This class represents an undirected graph in adjacency list format, and method for finding articulation point
class Graph {
	private int V;
	private LinkedList<Integer> adj[];
	int time = 0;
	static final int NIL = -1;

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
		adj[v].add(u);
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
	
	void APUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap){
		//count the children
		int children = 0;

		//mark current node as visited
		visited[u] = true;

		//initialize discovery time and low value
		disc[u] = low[u] = ++time;

		//go through all vertices adjacent to u
		Iterator<Integer> it = adj[u].iterator();
		while(it.hasNext()){
			int v = it.next();

			if(!visited[v]){
				children++;
				parent[v] = u;
				APUtil(v,visited, disc, low, parent, ap);

				low[u] = Math.min(low[u], low[v]);

				//check if u is the root
				if(parent[u] == NIL && children > 1)
					ap[u] = true;
				
				if(parent[u] != NIL && low[v] >= disc[u])
					ap[u] = true;
			}
			//update low value of u for parent function calls
			else if(v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
	}
	//Articulation point using DFS traversal
	void AP(){
		boolean[] visited = new boolean[V];	//to mark visited or not
		int[] disc = new int[V];		//for storing discovery time
		int[] low = new int[V];			//for storing low number
		int[] parent = new int[V];		//for storing parent vertex
		boolean[] ap = new boolean[V];		//for storing articulation points

		//initialize all the arrays
		Arrays.fill(visited, false);
		Arrays.fill(disc, 0);
		Arrays.fill(low, 0);
		Arrays.fill(parent, NIL);
		Arrays.fill(ap, false);

		//call recursive APUtil for computing articulation points
		//in DFS tree rooted with vertex i
		for(int i=0; i < V; i++){
			if(!visited[i]){
				APUtil(i, visited, disc, low, parent, ap);
			}
		}

		//print articulation points(vertices)
		for(int i=0; i<V; i++){
			if(ap[i])
				System.out.println(i + " ");
		}
		
	}
	
}
public class ArticulationPoint{
	
	public static void main(String[] args){
		Graph g1 = new Graph(5);
		g1.addEdge(1,0);
		g1.addEdge(0,2);
		g1.addEdge(2,1);
		g1.addEdge(0,3);
		g1.addEdge(3,4);
		System.out.println("The input graph:");
		g1.print();
		System.out.println("Articulation points");
		g1.AP();
	}
}
