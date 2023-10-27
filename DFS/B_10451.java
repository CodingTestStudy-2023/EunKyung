package DFS;

import java.io.*;
import java.util.*;

public class B_10451 {

	static int[] arr;
	static boolean[] visited;
	static int cycle;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
        
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {

			int n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			cycle=0;
			
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[n+1];

			for(int j=1; j<n+1; j++) {

				if(!visited[j]) {
					DFS(j);
					cycle++;
				}
			}
			System.out.println(cycle);
		}
	}
	
	static void DFS(int start) {

		visited[start]= true;
		int next= arr[start];
		if(!visited[next]) {
			DFS(arr[start]);
		}	
	}
}