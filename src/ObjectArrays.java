public class ObjectArrays {
    public static void main(String[] args) {
        String[] as = new String[5];
        //stampare maiuscola prima stringa
        // System.out.println(as[0].toUpperCase());
        String[] students = {"Vittorio Aquila,Gryffindor","Lorenzo Coretti,Ravenclaw"};
        System.out.println(students[0].toUpperCase());
        String[] gryffindor = new String[6];
        String s1 = students[0];
        int grCounter = 0;
        String[] sTokens = s1.split(",");
        System.out.println(sTokens[0]);
        System.out.println(sTokens[1]);
    }
}
