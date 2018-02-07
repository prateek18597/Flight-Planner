import java.util.*;
import java.io.*;

public class Main
{
	int vertex[];
	boolean ver[];
	int num_v,num_e;
	Edge[] edge;
	ArrayList<LinkedList<Integer>> graph=new ArrayList<>();
	Node[] node;

	public static class Edge
	{
		int city1,city2,atime,dtime,price;
		String id;
		public Edge()
		{
		}
	}

	public void Dijkstra(int pos,int dest,int arrival,int departure)
	{
		ClearNode();
		PriorityQueue<Node2> pq=new PriorityQueue(new PriceComparator());
		pq.add(new Node2(node[pos],arrival));
		node[pos].price=0;
		int prev=arrival;
		int starting =100;
		while(!pq.isEmpty())
		{
			Node2 temp1=pq.poll();
			int temp=temp1.node.vert;
			//System.out.println(temp);
			int tmr=temp1.timer;
			int size=graph.get(temp-1).size();
			// int xyx[]=new int[size-1];
			// int yxy[]=new int[size-1];
			for(int i=1	;i<size;i++)
			{
				int ppp=node[temp].price+edge[graph.get(temp-1).get(i)].price;
				// if(edge[graph.get(temp-1).get(i)].atime>arrival && edge[graph.get(temp-1).get(i)].dtime<departure)
				// {
				int tx=edge[graph.get(temp-1).get(i)].atime;
				int ty=edge[graph.get(temp-1).get(i)].dtime;
				if(starting!=100 && tx-tmr>=30 && ty<=departure){
						if(node[edge[graph.get(temp-1).get(i)].city2].price==-1)
						{
							if(edge[graph.get(temp-1).get(i)].atime>=arrival){// && edge[graph.get(temp-1).get(i)].dtime<=departure){
								node[edge[graph.get(temp-1).get(i)].city2].price=node[temp].price+edge[graph.get(temp-1).get(i)	].price;	
								pq.add(new Node2(node[edge[graph.get(temp-1).get(i)].city2],edge[graph.get(temp-1).get(i)].dtime));}	
						}
						else if(node[edge[graph.get(temp-1).get(i)].city2].price > ppp)
						{
							node[edge[graph.get(temp-1).get(i)].city2].price=ppp;
							//pq.poll();
							//pq.add(new Node2(node[edge[graph.get(temp-1).get(i)].city2],edge[graph.get(temp-1).get(i)].dtime));
						}
						prev=tx;

				}
				else if(starting==100 && ty<=departure)
				{
					if(node[edge[graph.get(temp-1).get(i)].city2].price==-1)
						{
							if(edge[graph.get(temp-1).get(i)].atime>=arrival){// && edge[graph.get(temp-1).get(i)].dtime<=departure){
								node[edge[graph.get(temp-1).get(i)].city2].price=node[temp].price+edge[graph.get(temp-1).get(i)	].price;	
								pq.add(new Node2(node[edge[graph.get(temp-1).get(i)].city2],edge[graph.get(temp-1).get(i)].dtime));}	
						}
						else if(node[edge[graph.get(temp-1).get(i)].city2].price >= ppp)
						{
							node[edge[graph.get(temp-1).get(i)].city2].price=ppp;
							//pq.poll();
							//pq.add(new Node2(node[edge[graph.get(temp-1).get(i)].city2],edge[graph.get(temp-1).get(i)].dtime));
						}
						prev=tx;
						starting=0;
				}
				
			}
			//Changing here

		}
		System.out.println(node[dest].price);

	}

	void ClearNode()
	{
		for(int i=1;i<num_v;i++)
		{
			node[i].price=-1;
		}
	}


	void displayGraph()
	{

		
		for(int i=0;i<num_v-1;i++)
		{
			int size=graph.get(i).size();
			System.out.print(graph.get(i).get(0)+"---->");
			for(int j=1;j<size;j++)
			{
				System.out.print(edge[graph.get(i).get(j)].city2+" ");
			}
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		try
		{

			//File file=new File("input.txt");
			Main m=new Main();
			Scanner s=new Scanner(System.in);
			m.num_v=s.nextInt()+1;
			m.vertex=new int[m.num_v];
			m.ver=new boolean[m.num_v];
			m.node=new Node[m.num_v];
			//
			//System.out.println("NP");
			for(int i=1;i<m.num_v;i++)
			{
				m.vertex[i]=i;
				m.ver[i]=false;
				m.graph.add(new LinkedList<>());
				m.node[i]=new Node(i,-1);
				
				m.graph.get(i-1).add(i);
				//System.out.println(m.graph.get(i-1).get(0));
			}
			// System.out.println("NP");
			m.num_e=(s.nextInt())+1;
			m.edge=new Edge[m.num_e];
			for(int i=1;i<m.num_e;i++)
			{
				int temp1=s.nextInt();
				int temp2=s.nextInt();
				
				int temp3=Integer.parseInt(s.next());
				
				int temp4=Integer.parseInt(s.next());
				
				String temp5=s.next();
				m.edge[i]=new Edge();
				int temp6=s.nextInt();
				m.edge[i].city1=temp1;			
				m.edge[i].city2=temp2;
				m.edge[i].atime=temp3;
				m.edge[i].dtime=temp4;
				m.edge[i].id=temp5;
				m.edge[i].price=temp6;
				
				m.graph.get(temp1-1).add(i);

			}
			
			int query=s.nextInt();
			for(int i=0;i<query;i++)
			{
				m.Dijkstra(s.nextInt(),s.nextInt(),s.nextInt(),s.nextInt());
					
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error"+e.getMessage());
		}

	}
}
