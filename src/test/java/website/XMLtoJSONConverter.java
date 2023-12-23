package website;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class Website {
    @JacksonXmlProperty(localName = "URL")
    private String url;

    @JacksonXmlProperty(localName = "Tile")
    private String title;

    @JacksonXmlProperty(localName = "Description")
    private String description;

    @JacksonXmlProperty(localName = "CreatedDate")
    private String createdDate;

    public String getUrl() {
    }

    public String getTitle() {
    }

    public String getDescription() {
    }

    public String getCreatedDate() {
    }

}

class WebsiteList {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Website")
    private List<Website> websites;

    public Website[] getWebsites() {
    }

}

public class XMLtoJSONConverter {

    public static void main(String[] args) throws Exception {
        ObjectMapper xmlMapper = new XmlMapper();
        WebsiteList websiteList = xmlMapper.readValue(new File("test.xml"), WebsiteList.class);

        // Add new attributes
        for (Website website : websiteList.getWebsites()) {
            // Add new attributes as needed
        }

        // Convert to JSON
        ObjectMapper jsonMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String jsonString = jsonMapper.writeValueAsString(websiteList);
        System.out.println(jsonString);

        // Get websites created after September 1
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        Date thresholdDate = dateFormat.parse("09/01/2023 00:00:00 AM");

        // Print information
        int websiteNumber = 1;
        for (Website website : websiteList.getWebsites()) {
            Date createdDate = dateFormat.parse(website.getCreatedDate());
            if (createdDate.after(thresholdDate)) {
                printWebsiteInfo(website, websiteNumber++);
            }
        }
    }

    private static void printWebsiteInfo(Website website, int websiteNumber) {
        System.out.println("Website " + websiteNumber + ":");
        System.out.println("URL: " + website.getUrl());
        System.out.println("Title: " + website.getTitle());
        System.out.println("Description: " + website.getDescription());
        System.out.println("Created Date: " + website.getCreatedDate());
        System.out.println();
    }
}

