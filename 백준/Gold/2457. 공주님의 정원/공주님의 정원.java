import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int []cal = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int [][]arr=new int[n][2];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int start=0;
			for(int j=0;j<a;j++) {
				start+=cal[j];
			}
			start+=b;
			int end=0;
			for(int j=0;j<c;j++) {
				end+=cal[j];
			}
			end+=d;
			arr[i][0]=start;
			arr[i][1]=end;
		}
		Arrays.sort(arr,(o1,o2)->{
			if(o1[0]==o2[0])return o2[1]-o1[1];
			return o1[0]-o2[0];
		});
		System.out.println(check(arr));
		
	}static int check(int arr[][]) {
		int s=60;
		int e=335;
		int start=0;
		int end=60;
		int res=0;
		int dif=0;
		boolean ck=false;
		for(int i=0;i<arr.length;i++) {
			int ns=arr[i][0];
			int ne=arr[i][1];
			if(ne<s||ns>e||ns==start)continue;
			if(ns>=start && ne<=end)continue;
			if(ns<=end) {
				ck=true;
				dif=Math.max(ne-end, dif);
			}else {
				end+=dif;
				if(ns>end)return 0;
				res++;
				if(end>=e) {
					ck=false;
					break;
				}
				if(end<ne) {
					ck=true;
					dif=ne-end;
				}
				else {
					ck=false;
					dif=0;
				}
			}
		}
		if(ck)res++;
		if(end+dif<e)return 0;
		return res;
		
		
	}
}
