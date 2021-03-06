// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
// write a function to check whether these edges make up a valid tree.
//
// For example:
//
// Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
//
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
//
// Hint:
//
// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return?
// Is this case a valid tree? Show More Hint Note: you can assume that no duplicate edges will appear in edges.
// Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
public class Solution {
    //using union find to get check whether there is loop or not
    public boolean validTree(int n, int[][] edges) {
      int nEdge = edges.length;
      if (nEdge != n - 1) return false;
      int []root = new int[n];
      for (int i = 0; i < n; i++) root[i] = i;
      for (int[]edge : edges){
        if (findRoot(edge[0],root) == findRoot(edge[1],root)) return false;
        root[findRoot(edge[0],root)] = root[findRoot(edge[1],root)];//union
      }
      return true;
    }
    private int findRoot(int i, int []root){
      while(i != root[i]) i = root[i];
      return i;
    }
  }
