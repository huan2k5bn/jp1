import Entity.ProductData;
import Service.FileService;

import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        services.FileService fileService = new services.FileService();
        List<ProductData> productDataList = fileService.readFile(inputFilePath);
        Map<String, Map<String, Integer>> aggregatedData = aggregateData(productDataList);
        List<String> outputData = calculateAndFormatOutput(aggregatedData);
        fileService.writeFile(outputFilePath, outputData);
    }

    public static Map<String, Map<String, Integer>> aggregateData(List<ProductData> dataList) {
        Map<String, Map<String, Integer>> aggregatedData = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        for (ProductData data : dataList) {
            String monthYear = sdf.format(java.sql.Date.valueOf(data.getDateTime()));
            String key = data.getIdSanPham() + ";" + monthYear;

            aggregatedData.putIfAbsent(key, new HashMap<>());
            Map<String, Integer> metrics = aggregatedData.get(key);
            metrics.put("click", metrics.getOrDefault("click", 0) + data.getClick());
            metrics.put("addToCart", metrics.getOrDefault("addToCart", 0) + data.getAddToCart());
            metrics.put("checkOut", metrics.getOrDefault("checkOut", 0) + data.getCheckOut());
        }
        return aggregatedData;
    }

    public static List<String> calculateAndFormatOutput(Map<String, Map<String, Integer>> aggregatedData) {
        List<String> outputData = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> entry : aggregatedData.entrySet()) {
            String key = entry.getKey();
            Map<String, Integer> metrics = entry.getValue();
            int click = metrics.get("click");
            int addToCart = metrics.get("addToCart");
            int checkOut = metrics.get("checkOut");

            Map<String, Double> percentages = ProductData.calculatePercentages(click, addToCart, checkOut);

            String formattedOutput = String.format("%s; %.2f%%; %.2f%%; %.2f%%", key,
                    percentages.getOrDefault("click", 0.0),
                    percentages.getOrDefault("addToCart", 0.0),
                    percentages.getOrDefault("checkOut", 0.0));
            outputData.add(formattedOutput);
        }
        return outputData;
    }
}