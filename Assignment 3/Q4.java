package assignment3;
import java.util.*;
public class Q4 {
	 int count;
	 private LinkedList<LinkedList<Edge>>Adj;
		
	private	static class Edge{
	 private int dest;
	 private int cost;
		
	public	Edge(int dst,int cst){
	 dest=dst; 
	 cost=cst;
	 } 
	 }
		 
	public	Q4(int cnt)	{
	 count=cnt;
	 Adj=new	LinkedList<LinkedList<Edge>>();
	 for(int i	= 0;i<cnt;i++)	{
	 Adj.add(new LinkedList<Edge>());
	 }
	 }
		
	private	void addDirectedEdge(int source,int dest,int cost)	{
		Edge edge = new	Edge(dest,cost);
		 Adj.get(source).add(edge);	
		 }
			
		public void addDirectedEdge(int source,int dest)	{
		 addDirectedEdge(source,dest,1);
		 }
			
		public void addUndirectedEdge(int source,int dest,int cost)	{
		 addDirectedEdge(source,dest,cost);
		 addDirectedEdge(dest,source,cost);
		 }
			
		public void addUndirectedEdge(int source,int dest)	{
		 addUndirectedEdge(source,dest,1);
		 } 
			
		public void	print()	{
		 for(int i=0;i<count;i++)	{
		 LinkedList<Edge>	ad	=	Adj.get(i);
		 System.out.print("\nVertex	"+i+" is connected to : ");
		 for(Edge	adn	:	ad)	{
		 System.out.print("("+adn.dest+", "	+adn.cost+")");
		 }
		 }
		 }

	public static void main(String[] args) {
		 Q4	gph	=	new	Q4(5);
		 gph.addDirectedEdge(0,	1,	3);
		 gph.addDirectedEdge(0,	4,	2);
		 gph.addDirectedEdge(1,	2,	1);
		 gph.addDirectedEdge(2,	3,	1);
		 gph.addDirectedEdge(4,	1,	-2);
		 gph.addDirectedEdge(4,	3,	1);
		 gph.print();

	}

}
