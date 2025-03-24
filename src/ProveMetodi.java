public class ProveMetodi {
    public static void main(String[] args) {
        String i1 = "pippio";
        String i2 ="Pluto";
        String[] cambio = swap(i1,i2);
        System.out.println(cambio[0]);


        
    }

    public static String[] swap(String z1 , String z2){
        String temp = z1;
        z1 =z2;
        z2 = temp;
        return new String[]{z1,z2};
    }

}
