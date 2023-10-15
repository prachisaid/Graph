package Graphs;

public class StringToInt {
    public static void main(String[] args) {
        String[] details = {
                "9751302862F0693","3888560693F7262","5485983835F0649","2580974299F6042","9976672161M6561",
                "0234451011F8013","4294552179O6482"
        };

        System.out.println(new StringToInt().countSeniors(details));
    }

    public int countSeniors(String[] details) {
        // 11 12
        int ans = 0;

        for(int i = 0; i < details.length; i++){
            String pass = details[i];
            int age = Integer.parseInt(pass.substring(11, 13));
            if(age >= 60){
                System.out.println(age + " " + ans);
            }
        }
        return ans;
    }
}
