package JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        String jsonInputFile = "D:\\java\\JSON_Assignment\\src\\main\\java\\JSON\\ipl_data.json";
        String jsonOutputFile = "censored_ipl_data.json";
        String csvInputFile = "D:\\java\\JSON_Assignment\\src\\main\\java\\JSON\\ipl_data.csv";
        String csvOutputFile = "censored_ipl_data.csv";

        try {
            processJsonFile(jsonInputFile, jsonOutputFile);
            processCsvFile(csvInputFile, csvOutputFile);
            System.out.println("Censored JSON and CSV files generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processJsonFile(String inputFile, String outputFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File(inputFile));

        if (rootNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) rootNode;
            for (JsonNode match : arrayNode) {
                ((ObjectNode) match).put("team1", censorTeamName(match.get("team1").asText()));
                ((ObjectNode) match).put("team2", censorTeamName(match.get("team2").asText()));
                ((ObjectNode) match).put("player_of_match", "REDACTED");
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), arrayNode);
        }
    }

    private static void processCsvFile(String inputFile, String outputFile) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        List<String> censoredLines = lines.stream().map(line -> {
            String[] parts = line.split(",");
            if (parts.length >= 7 && !parts[0].equals("match_id")) {
                parts[1] = censorTeamName(parts[1]);
                parts[2] = censorTeamName(parts[2]);
                parts[6] = "REDACTED";
            }
            return String.join(",", parts);
        }).collect(Collectors.toList());

        Files.write(Paths.get(outputFile), censoredLines);
    }

    private static String censorTeamName(String teamName) {
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            return parts[0] + " ***";
        }
        return teamName;
    }
}
