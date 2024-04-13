import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int[][] sdoku;
    static int zeroLen;
    static int[][] zero;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 스도쿠 입력
        sdoku = new int[9][9];
        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 0인 값의 좌표 입력
        zero = new int[81][];
        zeroLen = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sdoku[i][j] == 0) {
                    zero[zeroLen++] = new int[] {i, j};
                }
            }
        }
        
        // 숫자를 집어넣는 경우
        for (int i = 1; i <= 9; i++) {
            fill(0, i);
        }
    }
    
    static void fill(int idx, int num) {
        // 끝나는 조건에 걸리면 전부 출력 후 프로그램 종료
        if (idx == zeroLen) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sdoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        
        // 입력
        int x = zero[idx][0];
        int y = zero[idx][1];
        if (checkCol(x, y, num) && checkRow(x, y, num) && checkBox(x, y, num)) {
            sdoku[x][y] = num;
        } else {
            return;
        }
        
        // 분기
        for (int i = 1; i <= 9; i++) {
            fill(idx + 1, i);
        }
        sdoku[x][y] = '0';
    }
    
    static boolean checkCol(int x, int y, int c) {
        for (int i = 0; i < 9; i++) {
            if (i == y) {
                continue;
            }
            if (sdoku[x][i] == c) {
                return false;
            }
        }
        return true;
    }
    
    static boolean checkRow(int x, int y, int c) {
        for (int i = 0; i < 9; i++) {
            if (i == x) {
                continue;
            }
            if (sdoku[i][y] == c) {
                return false;
            }
        }
        return true;
    }
    
    static boolean checkBox(int x, int y, int c) {
        if (x < 3) {
            if (y < 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        if (sdoku[i][j] == c) {
                            return false;
                        }
                    }
                }
            } else if (y < 6) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        if (sdoku[i][j] == c) {
                            return false;
                        }
                    }
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    for (int j = 6; j < 9; j++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        if (sdoku[i][j] == c) {
                            return false;
                        }
                    }
                }
            }
        } else if (x < 6) {
            if (y < 3) {
                for (int i = 3; i < 6; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        if (sdoku[i][j] == c) {
                            return false;
                        }
                    }
                }
            } else if (y < 6) {
                for (int i = 3; i < 6; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        if (sdoku[i][j] == c) {
                            return false;
                        }
                    }
                }
            } else {
                for (int i = 3; i < 6; i++) {
                    for (int j = 6; j < 9; j++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        if (sdoku[i][j] == c) {
                            return false;
                        }
                    }
                }
            }
        } else {
            if (y < 3) {
                for (int i = 6; i < 9; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        if (sdoku[i][j] == c) {
                            return false;
                        }
                    }
                }
            } else if (y < 6) {
                for (int i = 6; i < 9; i++) {
                    for (int j = 3; j < 6; j++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        if (sdoku[i][j] == c) {
                            return false;
                        }
                    }
                }
            } else {
                for (int i = 6; i < 9; i++) {
                    for (int j = 6; j < 9; j++) {
                        if (x == i && y == j) {
                            continue;
                        }
                        if (sdoku[i][j] == c) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}