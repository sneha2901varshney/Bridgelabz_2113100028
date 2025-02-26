package JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class Project {
    public static void main(String[] args) {
        String jsonInputFile = "src/main/resources/ipl_matches.json"; // Adjust the path
        String csvInputFile = "src/main/resources/ipl_matches.csv"; // Adjust the path
        String jsonOutputFile = "src/main/resources/censored_ipl_matches.json"; // Output path
        String csvOutputFile = "src/main/resources/censored_ipl_matches.csv"; // Output path

        // Process JSON
        processJsonFile(jsonInputFile, jsonOutputFile);
        // Process CSV
        processCsvFile(csvInputFile, csvOutputFile);
    }

    private static void processJsonFile(String inputFile, String outputFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String, Object>> matches = objectMapper.readValue(new FileReader(inputFile), new TypeReference<List<Map<String, Object>>>() {});
            for (Map<String, Object> match : matches) {
                maskTeamNames(match);
                redactPlayerOfMatch(match);
            }
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(outputFile), matches);
            System.out.println("Censored JSON data written to " + outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processCsvFile(String inputFile, String outputFile) {
        try (CSVReader csvReader = new CSVReader(new FileReader(inputFile));
             CSVWriter csvWriter = new CSVWriter(new FileWriter(outputFile))) {
            String[] headers = csvReader.readNext(); // Read header line
            csvWriter.writeNext(headers); // Write header to output

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                maskTeamNamesInCsv(nextLine);
                redactPlayerOfMatchInCsv(nextLine);
                csvWriter.writeNext(nextLine); // Write modified line to output
            }
            System.out.println("Censored CSV data written to " + outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void maskTeamNames(Map<String, Object> match) {
        match.put("team1", maskTeamName((String) match.get("team1")));
        match.put("team2", maskTeamName((String) match.get("team2")));
        match.put("winner", maskTeamName((String) match.get("winner")));

        Map<String, Integer> score = (Map<String, Integer>) match.get("score");
        if (score != null) {
            score.keySet().forEach(team -> {
                score.put(maskTeamName(team), score.remove(team));
            });
        }
    }

    private static String maskTeamName(String teamName) {
        return teamName.replaceAll("(?<=\\w{6})\\w+", "***");
    }

    private static void redactPlayerOfMatch(Map<String, Object> match) {
        match.put("player_of_match", "REDACTED");
    }

    private static void maskTeamNamesInCsv(String[] row) {
        row[1] = maskTeamName(row[1]); // team1
        row[2] = maskTeamName(row[2]); // team2
        row[5] = maskTeamName(row[5]); // winner
    }

    private static void redactPlayerOfMatchInCsv(String[] row) {
        row[6] = "REDACTED"; // player_of_match
    }
}
