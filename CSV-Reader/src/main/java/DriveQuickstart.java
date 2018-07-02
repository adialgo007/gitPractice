import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.client.http.FileContent;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class DriveQuickstart {
    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FOLDER = "credentials"; // Directory to store user credentials.

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved credentials/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
  
    private static final String CLIENT_SECRET_DIR = "client_secret.json";
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/2/sheets.googleapis.com-java-quickstart.json");

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If there is no client_secret.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = DriveQuickstart.class.getResourceAsStream(CLIENT_SECRET_DIR);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(CREDENTIALS_FOLDER)))
                .setAccessType("offline")
                .build();
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
/*
        String fileId = "1l8qqz7XCsaZP1dRgZdTn3wQ8ITR4Mb2V";
OutputStream outputStream = new ByteArrayOutputStream();
driveService.files().export(fileId, "text/csv")
    .executeMediaAndDownloadTo(outputStream);
    */

        // Print the names and IDs for up to 10 files.
        FileList result = service.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
            }
        }

// Uploading File  
 /*
        File fileMetadata = new File();
        fileMetadata.setName("questionCSV.csv");
        String fileId = "1d3nNVVL99m4lB4iwtNhrtnPINf3ItAch";
        java.io.File filePath = new java.io.File("/Users/superstar/JavaProjects/src/main/resources/question2.csv");
        FileContent mediaContent = new FileContent("text/csv", filePath);
        File file = service.files().create(fileMetadata, mediaContent)
        .setFields("id")
        .execute();
        System.out.println("File ID: " + file.getId());
  */      

/*

        String fileId = "1NQ0eh0SWij1aqqQAyb0XzK8qYfUPfYdHQsfXFiXJFbY";
OutputStream outputStream = new ByteArrayOutputStream();
service.files().get(fileId)
    .executeMediaAndDownloadTo(outputStream);    */

        String fileId = "1NQ0eh0SWij1aqqQAyb0XzK8qYfUPfYdHQsfXFiXJFbY";
        OutputStream outputStream = new ByteArrayOutputStream();
        service.files().export(fileId, "text/csv")
                .executeMediaAndDownloadTo(outputStream);



   OutputStream outputStreamFile = new FileOutputStream ("/Users/superstar/Desktop/question.csv");
   ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream)outputStream;
byteArrayOutputStream.writeTo(outputStreamFile);


    
    
    
    }
}