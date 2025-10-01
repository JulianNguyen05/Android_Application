package th.nguyenhuutrong.th_quizzapp_total;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CauHoi {
    public int a, b;
    public int dapAnDung;
    public ArrayList<Integer> dapAnSais;

    public CauHoi(){
        Random rd = new Random();
        a = rd.nextInt(50) + 1;
        b = rd.nextInt(50) + 1;
        while (a + b >= 100){
            a = rd.nextInt(50) + 1;
            b = rd.nextInt(50) + 1;
        }
        dapAnDung = a + b;
        dapAnSais = new ArrayList<>();

        while (dapAnSais.size() < 4){
            int sai = dapAnDung + (rd.nextInt(20) - 10);
            if(sai > 0 && sai < 100 && !dapAnSais.contains(sai)){
                dapAnSais.add(sai);
            }
        }

        Collections.shuffle(dapAnSais);
    }

    public String getCauHoiText(){
        return a + " + " + b + " = ?";
    }
}
