package Service;

import Entity.ProductData;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class FileService {
    public List<ProductData> readFile(String filePath) {
        List<ProductData> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int idSanPham = Integer.parseInt(parts[0]);
                int click = Integer.parseInt(parts[1]);
                int addToCart = Integer.parseInt(parts[2]);
                int checkOut = Integer.parseInt(parts[3]);
                String dateTime = parts[4];
                dataList.add(new ProductData(idSanPham, click, addToCart, checkOut, dateTime));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public void writeFile(String filePath, List<String> outputData) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : outputData) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}