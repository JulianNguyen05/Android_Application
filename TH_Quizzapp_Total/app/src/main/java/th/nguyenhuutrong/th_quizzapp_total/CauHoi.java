package th.nguyenhuutrong.th_quizzapp_total;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CauHoi {
    public int a, b;
    public int dapAnDung;
    public ArrayList<Integer> dapAnList;

    public CauHoi() {
        Random rd = new Random();
        a = rd.nextInt(50) + 1;
        b = rd.nextInt(50) + 1;
        while (a + b >= 100) {
            a = rd.nextInt(50) + 1;
            b = rd.nextInt(50) + 1;
        }

        dapAnDung = a + b;
        dapAnList = new ArrayList<>();
        dapAnList.add(dapAnDung);

        while (dapAnList.size() < 4) {
            int sai = dapAnDung + (rd.nextInt(20) - 10);
            if (sai > 0 && sai < 100 && !dapAnList.contains(sai)) {
                dapAnList.add(sai);
            }
        }

        Collections.shuffle(dapAnList);
    }

    public String getCauHoiText() {
        return a + " + " + b + " = ?";
    }
}