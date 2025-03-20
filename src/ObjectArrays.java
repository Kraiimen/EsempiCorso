public class ObjectArrays {
    public static void main(String[] args) {
        String[] as = new String[5];
        // System.out.println(as[0].toUpperCase()); //ci sono 5 null dentro l'array
        String[] students = { "Regina Ghering, gryffindor", "Luna Am, ravenclaw" };
        System.out.println(students[0].toUpperCase());
        String[] gryffindor = new String[6];
        int grCounter = 0;
        gryffindor[grCounter] = "Ren";
        grCounter++;
        String s1 = students[0];
        System.out.println(s1);
        String[] sTokens = s1.split(",");
        System.out.println(sTokens[0]);
        System.out.println(sTokens[1]);



        


    }
}
