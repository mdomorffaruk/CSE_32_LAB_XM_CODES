import java.io.*;
import java.nio.file.Files;


public class Qs1 {
        public static void main(String[] args) throws IOException {

            String path = "C:\\Users\\sourov\\Desktop\\OS_LAB\\test.txt";
            File source = new File(path);
            String copyDestination = "C:\\Users\\sourov\\Desktop\\OS_LAB\\copy_test.txt";
            File copyDest = new File(copyDestination);
            String moveDestination = "C:\\Users\\sourov\\Desktop\\OS_LAB\\moved\\test.txt";
            File moveDest = new File(moveDestination);



            createAFile(path);
            copyAFile( source,  copyDest);
            deleteAFile(copyDest);
            moveAFile(source, moveDest);

        }

    private static void deleteAFile(File path) {
        System.out.println("deleting....");
        System.out.println("coping....");

        try
        {
            Files.delete(path.toPath());
            System.out.println("File Deleted from " + path.toPath());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private static void moveAFile(File source, File moveDest) throws IOException {
        System.out.println("moving....");
        File file = new File(moveDest.toString());
        if(file.exists() && !file.isDirectory()) {
            System.out.println("File not move, already exist at : "+file.getCanonicalPath());
        }else {
            try {
                Files.move(source.toPath(), moveDest.toPath());
                System.out.println("File move from " + source.toPath() + " to " + moveDest.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void copyAFile(File source, File dest) throws IOException {
        System.out.println("coping....");
        File file = new File(dest.toString());
        if(file.exists() && !file.isDirectory()) {
            System.out.println("File already exist at : "+file.getCanonicalPath());
        }else{
            try
            {
                Files.copy(source.toPath(), dest.toPath());
                System.out.println("File copied at " + dest.toPath());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    private static void createAFile(String path) {
        System.out.println("creating....");
        File file = new File(path);
        boolean result;
        try
        {
            result = file.createNewFile();
            if(result)
            {
                System.out.println("file created "+file.getCanonicalPath());
            }
            else
            {
                System.out.println("File already exist at : "+file.getCanonicalPath());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}

