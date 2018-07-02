package com.example.csvReaderQuestions;

import com.google.api.services.drive.Drive;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.sun.deploy.net.HttpResponse;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.example.csvReaderQuestions.pojo.Question;
import sun.net.www.http.HttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class QuestionsCSVReader {


    private static final String SAMPLE_CSV_FILE_PATH = "/Users/superstar/Desktop/question.csv";
    private static List<Question> questionsList;
    public static void main(String[] args) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<Question> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Question.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            questionsList = csvToBean.parse();

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            String URL = "http://10.177.2.15:8080/question/saveAll";
            HttpEntity<Object> entity = new HttpEntity<Object>(questionsList,httpHeaders);
            ResponseEntity<Boolean> rs = restTemplate.exchange(URL, HttpMethod.POST, entity,new ParameterizedTypeReference<Boolean>() {});

            for(Question question: questionsList) {

                System.out.println("Name : " + question.getDifficulty());
                System.out.println(question.getAnswer());
                System.out.println(question.getCategoryId());
                System.out.println(question.getOptionOne());
                //  System.out.println(question.getOptionOne());

                System.out.println("==========================");
            }
        }

    }
}
