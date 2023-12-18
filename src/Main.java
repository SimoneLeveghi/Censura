public class Main {
    public static void main(String[] args) {
        System.out.println(censura("Il furly è un Furly con il fUrly", new String[]{"Furly"}));
    }

    public static String censura(String s, String[] pCensura) {
        String newString = s;
        for(String p : pCensura) {
            p = p.toLowerCase();
            String asterix = "";
            for(int i = 0; i < p.length(); ++i) {
                asterix += "*";
            }
            int indexOcc = Math.min(
                    newString.indexOf(p.charAt(0)) != -1 ? newString.indexOf(p.charAt(0)) : newString.length(),
                    newString.indexOf(Character.toLowerCase(p.charAt(0))) != -1 ? newString.indexOf(Character.toLowerCase(p.charAt(0))) : newString.length());

            while(indexOcc != newString.length()) {
                int i;
                for (i = 1; i < p.length(); ++i) {
                    if (!(Character.toLowerCase(newString.charAt(indexOcc + i)) == p.charAt(i))) {
                        break;
                    }
                }

                if (i == p.length()) {
                    newString = newString.substring(0, indexOcc) + asterix + newString.substring(indexOcc + i);
                }

                indexOcc = Math.min(
                        newString.indexOf(p.charAt(0)) != -1 ? newString.indexOf(p.charAt(0)) : newString.length(),
                        newString.indexOf(Character.toLowerCase(p.charAt(0))) != -1 ? newString.indexOf(Character.toLowerCase(p.charAt(0))) : newString.length()
                );
            }
        }

        return newString;
    }

}