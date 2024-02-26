import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people[i] = new Person(weight, height);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (people[i].weight < people[j].weight && people[i].height < people[j].height) {
                    people[i].rank++;
                }
            }
        }

        for (Person person : people) {
            System.out.print(person.rank + " ");
        }
    }
}

class Person {
    int weight, height;
    int rank = 1;
    Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}