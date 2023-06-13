import java.util.HashMap;
import java.io.IOException;
import java.io.*;
import java.lang.*;


public class AddressBook {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String,String> directorio = new HashMap<>();
    public static void main(String[] args) throws IOException {
    load();
    boolean a = true;
    while (a) {
        System.out.println("Eliga opcion:");
        System.out.println("1 Mostrar Lista");
        System.out.println("2 Agregar numero");
        System.out.println("3 Eliminar numero ");
        System.out.println("4 Terminar operacion ");
        int res = Integer.parseInt(br.readLine());
        switch (res){
            case 1:
                list();
                break;
            case 2:
                create();
                break;
            case 3:
                delete();
                break;
            case 4:
                a = false;
                break  ;
            default:
                System.out.println("Opcion invalida");
                break;

        }

    }
   save();







           // bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));



    }

    public static void load() {
        String inputFilename = "C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\Direct.txt";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFilename));
            // bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));

            String line;
            String number = null;
            String name = null;
            boolean primero = true;
            String actual = null;
            while ((line = bufferedReader.readLine()) != null) {
                primero = true;
                number = "";
                name = "";
                for (int i = 0; i <line.length(); i++){
                    actual = String.valueOf(line.charAt(i));
                    if (actual.equals(";")) {
                        i= i+1;
                        primero = false;
                    }
                    if  (primero) {
                        number = number + line.charAt(i);

                    } else {name = name + line.charAt(i);}
                }
                directorio.put(number,name);
            }
            // bufferedWriter.write(line + "\n");

        } catch(IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }

            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }
    public static void save() {
        String outputFilename = "C:\\Users\\migue\\OneDrive - Universidad Tecmilenio\\Tetramestre 5\\Certificacion de Java 1\\Direct.txt";
        BufferedWriter bufferedWriter = null;

        try {

            bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));

            for (String number: directorio.keySet()) {
                String key = number.toString();
                String value = directorio.get(number).toString();
                bufferedWriter.write(key + ";" + value+ "\n");
            }




        } catch(IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {

                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }


    }

    public static void list(){
        for (String number: directorio.keySet()) {
            String key = number.toString();
            String value = directorio.get(number).toString();
            System.out.println(key + ":" + value);
        }


        }
    public static void create() throws IOException {
        System.out.println("Ingrese Numero");
        String num = br.readLine();
        System.out.println("Ingrese Nombre");
        String nam = br.readLine();
        directorio.put(num,nam);

    }
    public static void delete() throws IOException {
        System.out.println("Ingrese Numero");
        String num = br.readLine();
        directorio.remove(num);

    }

    }











