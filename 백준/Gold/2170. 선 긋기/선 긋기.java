import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class line{
	int s,e;

	public line(int s, int e) {
		super();
		this.s = s;
		this.e = e;
	}
}

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Stack<Integer>stack=new Stack<>();
		line []arr=new line[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[i]=new line(a,b);
		}
		Arrays.sort(arr,(o1,o2)->{
			return o1.s-o2.s;
		});
		stack.push(arr[0].s);
		stack.push(arr[0].e);
		int  sum=0;
		for(int i=1;i<n;i++) {
			int now=stack.pop();
			if(now>=arr[i].s) {
				if(now>=arr[i].e) {
					stack.push(now);
				}else {
					stack.push(arr[i].e);
				}
			}
			else {
				sum+=Math.abs(now-stack.pop());
				stack.push(arr[i].s);
				stack.push(arr[i].e);
			}
		}
		if(!stack.isEmpty()) {
			int a=stack.pop();
			int b=stack.pop();
			sum+=Math.abs(a-b);
		}
		System.out.println(sum);
		
	}
}
