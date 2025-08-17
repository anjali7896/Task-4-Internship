import java.io.*;

public class ProductFilter {
    public static void main(String[] args) {
        String inputFile = "products.csv";
        String outputFile = "expensive_products.csv";

        // Step 1: Create a sample products.csv
        try (FileWriter writer = new FileWriter(inputFile)) {
            writer.write("Laptop,1500\n");
            writer.write("Mouse,25\n");
            writer.write("Phone,999\n");
            writer.write("Monitor,1200\n");
            writer.write("Keyboard,100\n");
        } catch (IOException e) {
            System.out.println("Error creating input file: " + e.getMessage());
            return;
        }

        // Step 2–5: Read, filter, and write to a new file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) continue;

                String name = parts[0];
                double price = Double.parseDouble(parts[1]);

                if (price > 1000) {
                    writer.write(name + "," + price + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
            return;
        }

        // Step 6: Print success message
        System.out.println("Filtered products written to " + outputFile);

        // Step 7: Verify the output file
        System.out.println("\nContents of " + outputFile + ":");
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading output file: " + e.getMessage());
        }
    }
}
