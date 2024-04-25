import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int map[][];
	static int r,c;
	static boolean wall[][][];
	static int dx[] = {0,0,-1,0,1};
	static int dy[] = {0,-1,0,1,0};
	static int cnt;
	static boolean visit[][];
	static List<Integer>count=new ArrayList<>();
	static int res;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		c=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		map=new int[r][c];
		count.add(0);
		wall=new boolean[r][c][5];
		int tmp=1;
		for(int i=0;i<r;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				int num=Integer.parseInt(st.nextToken());
				makeWall(num, i, j);
			}
		}
		visit=new boolean [r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(!visit[i][j]) {
					visit[i][j]=true;
					cnt=0;
					dfs(i,j,tmp);
					count.add(cnt);
					tmp++;
				}
			}
		}
		System.out.println(tmp-1);
		int max=0;
		for(int i=1;i<count.size();i++) {
			max=Math.max(max, count.get(i));
		}
		System.out.println(max);
		res=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				check(i,j);
			}
		}
		System.out.println(res);
	}
	static void makeWall (int n,int x , int y) {
		String str=Integer.toBinaryString(n);
		int idx=1;
		for(int i=str.length()-1; i>=0; i--) {
			if(str.charAt(i)=='1') {
				wall[x][y][idx]=true;
			}
			idx++;
		}
	}
	static void dfs(int x, int y,int num) {
		map[x][y]=num;
		cnt++;
		for(int i=1;i<5;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>r-1||ny>c-1)continue;
			if(visit[nx][ny]||wall[x][y][i])continue;
			visit[nx][ny]=true;
			dfs(nx,ny,num);
		}
	}
	static void check(int x, int y) {
		for(int i=1;i<5;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>r-1||ny>c-1)continue;
			if(map[nx][ny]==map[x][y]) continue;
			res=Math.max(count.get(map[x][y])+count.get(map[nx][ny]), res);
		}
	}
}