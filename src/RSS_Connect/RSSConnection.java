package RSS_Connect;

import GUI.AddFeedInputbox;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
//http://www.vogella.com/tutorials/RSSFeed/article.html
// https://echo360.e-ope.ee/ess/echo/presentation/19721ac2-d689-430d-a1a0-1a827c5fff4d?ec=true

public class RSSConnection {

    public Document doc;
    public Elements item, title, description, link;
    public ArrayList titleString = new ArrayList();
    public ArrayList<ArrayList<String>> newsItem = new ArrayList<ArrayList<String>>();

    public String inputUrl = AddFeedInputbox.answer;

    public RSSConnection() {

        System.out.println(AddFeedInputbox.answer);
        try {
            Document doc;
            doc = Jsoup.connect(inputUrl).get();
            item = doc.select("item");
            System.out.println("[+] Connected to " + inputUrl);


            for (Element element : item) {


                ArrayList<String> buffer = new ArrayList<String>();
                title = element.select("title");
                description = element.select("description");
                link = element.select("link");
                titleString.add((String) title.text());
                buffer.add((String) title.text());
                buffer.add((String) description.text());
                buffer.add((String) link.text());
                newsItem.add(buffer);
            }

        } catch (Exception e) {
            System.out.println("[-] Errooor");
        }
        System.out.println("JESSSS");
    }


    public boolean testConnection(String inputUrl) {

        try {
            doc = Jsoup.connect(inputUrl).get();
        } catch (Exception e) {
            System.out.println("Boooo " + inputUrl + " failed.");
            return false;
        }
        System.out.println("Wooop " + inputUrl + " successful");
        return true;
    }

    public ArrayList<String> getTitle() {
        return titleString;

    }

    public ArrayList<ArrayList<String>> getNewsItem() {
        return newsItem;
    }
}


