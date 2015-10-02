package package1;

public class Sort implements Runnable {

    private int[] mas;
    private int d;
    private int num;

    public Sort(int[] mas, int d, int num) {
        this.mas = mas;
        this.d = d;
        this.num = num;
    }

    @Override
    public  void run() {
        for (int i = num ; i < mas.length; i = i + d) {
            int curr = mas[i];
            int prevKey = i - d;
            while ((prevKey >= 0) && (mas[prevKey] > curr)) {
                mas[prevKey + d] = mas[prevKey];
                mas[prevKey] = curr;
                prevKey = prevKey - d;
            }
        }
    }

}
