package com.chickengame.mini.games;

import java.util.Random;

public class Lotto implements Game{

    /*           행운의 로또 번호            */

    public static void main(String[] args) {

        System.out.println();
        System.out.println("    ◠‿◠ 행운의 로또 번호 ◠‿◠ ");
        System.out.println();
        System.out.println(" ◠◠   ◠◠   ◠◠   ◠◠   ◠◠   ◠◠");

        /* 번호 6개씩 5줄 출력 */
        int[] lotto = new int[6];
        Random r = new Random();

        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < lotto.length; i++) {
                lotto[i] = r.nextInt(45) + 1;
                for (int j = 0; i < j; j++) {
                    if (lotto[i] == lotto[j]) {
                        i--;
                        break;
                    }
                }
            }

            for (int i = 1; i < lotto.length; i++) {

                for (int j = 0; j < i; j++) {

                    if (lotto[i] < lotto[j]) {
                        int temp;
                        temp = lotto[i];
                        lotto[i] = lotto[j];
                        lotto[j] = temp;
                    }
                }
            }

            for (int i = 0; i < lotto.length; i++) {

                System.out.printf("%3s  ", lotto[i]);
            }
            System.out.println();
        }

    }



}
