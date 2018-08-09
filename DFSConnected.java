import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DFSConnected {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int column = in.nextInt();
		int grid[][] = new int[row][column];
		for(int grid_i=0; grid_i < row; grid_i++){
			for(int grid_j=0; grid_j < column; grid_j++){
				grid[grid_i][grid_j] = in.nextInt();
			}
		}

		GraphNode[][] graph = new GraphNode[row][column];
		for(int i=0; i<row; i++) {
			for(int j=0;j<column;j++) {
				if(grid[i][j]==1){
					GraphNode node = new GraphNode(i, j);
					if(i!=row-1 && grid[i+1][j]==1) {
						node.adjacent.add(new GraphNode(i+1, j));
						if(j!= column-1 && grid[i+1][j+1]==1)
							node.adjacent.add(new GraphNode(i+1, j+1));	
						if(j!=0 && grid[i+1][j-1]==1)
							node.adjacent.add(new GraphNode(i+1, j-1));
					}
					if(i!=0) {
						if(grid[i-1][j]==1)
							node.adjacent.add(new GraphNode(i-1, j));
						if(j!= column-1 && grid[i-1][j+1]==1)
							node.adjacent.add(new GraphNode(i-1, j+1));	
						if(j!=0 && grid[i-1][j-1]==1)
							node.adjacent.add(new GraphNode(i-1, j-1));	
					}
					if(j!= column-1 && grid[i][j+1]==1) {

						node.adjacent.add(new GraphNode(i, j+1));

					}
					if(j!=0 && grid[i][j-1]==1) {
						node.adjacent.add(new GraphNode(i, j-1));
					}
					graph[i][j]=node;
				}
			}
		}

		int longestRegion = 0;

		for(int i=0; i<row; i++) {
			for(int j=0;j<graph[0].length;j++) {

				if(graph[i][j]!= null) {
					HashSet<GraphNode> nodes = new HashSet<>();
					nodes.add(graph[i][j]);
					int regionSize  = getLongestRegion(graph[i][j], i,j,row,column).size();

					if(longestRegion<regionSize)
						longestRegion = regionSize;
				}
			}
		}

		System.out.println(longestRegion);

	}

	private static HashSet<GraphNode> getLongestRegion(GraphNode node, int i, int j, int row, int col) {

		HashSet<GraphNode>[][] nodes = new HashSet[row][col];
		if(nodes[i][j]==null) {
			nodes[i][j] = new HashSet<>();
			nodes[i][j].add(node);
			for(GraphNode child:node.adjacent) {
				if(nodes[i][j].contains(child))
					continue;
				else {
					nodes[i][j].add(child);
					nodes[i][j].addAll(getLongestRegion(child, child.row,child.column,row,col));

				}
			}
		}
				
		return nodes[i][j];

	}

}

class GraphNode{
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return("<"+this.row+","+this.column+"> adjacent:"+this.adjacent.toString());
	}
	@Override
	public boolean equals(Object obj) {
		if(this.row == ((GraphNode)obj).row && this.column == ((GraphNode)obj).column)
			return true;
		return false;
	}
	LinkedList<GraphNode> adjacent = new LinkedList<>();
	int row;
	int column;
	public GraphNode(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
