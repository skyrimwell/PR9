package Part1;

public class INNCheck {
    boolean checkKey(String inn) {
        int keyFstK = 0, keySndK = 0;
        String innKey = inn.substring(inn.length() - 2);

        for (int i = 0; i < 12; i++) {
            switch (i + 1) {
                case 1 -> {
                    keyFstK += inn.charAt(i) * 7;
                    keySndK += inn.charAt(i) * 3;
                }
                case 2 -> {
                    keyFstK += inn.charAt(i) * 2;
                    keySndK += inn.charAt(i) * 7;
                }
                case 3 -> {
                    keyFstK += inn.charAt(i) * 4;
                    keySndK += inn.charAt(i) * 2;
                }
                case 4 -> {
                    keyFstK += inn.charAt(i) * 10;
                    keySndK += inn.charAt(i) * 4;
                }
                case 5 -> {
                    keyFstK += inn.charAt(i) * 3;
                    keySndK += inn.charAt(i) * 10;
                }
                case 6 -> {
                    keyFstK += inn.charAt(i) * 5;
                    keySndK += inn.charAt(i) * 3;
                }
                case 7 -> {
                    keyFstK += inn.charAt(i) * 9;
                    keySndK += inn.charAt(i) * 5;
                }
                case 8 -> {
                    keyFstK += inn.charAt(i) * 4;
                    keySndK += inn.charAt(i) * 9;
                }
                case 9 -> {
                    keyFstK += inn.charAt(i) * 6;
                    keySndK += inn.charAt(i) * 4;
                }
                case 10 -> {
                    keyFstK += inn.charAt(i) * 6;
                }
            }
        }
        keyFstK %= 11;
        keySndK %= 11;
        if(keyFstK > 9)
            keyFstK %= 10;
        if(keySndK > 9)
            keySndK %= 10;

        String k1 = Integer.toString(keyFstK);
        String k2 = Integer.toString(keySndK);
        String checkKey = k1 + k2;
        System.out.println(checkKey);
        return innKey.equals(checkKey);
    }
}
