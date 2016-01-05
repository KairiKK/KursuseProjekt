package RSS_Connect;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Kairi on 19.12.2015.
 *
 * RSS feed connection jsoup abil  PEAKS VÕTMA KÕIK LAHTI. TEEB SELLEST ARRAY LISTI JA SIIS TULEB PASSIDA WINDOW CLASSI EDAST JA TEEB NÄHTAVAKS
 * http://jsoup.org/cookbook/
 */
public class ConnectRSS {

    public Document doc;
    public Elements item, title, link, description;
    public ArrayList titleString = new ArrayList();
    public ArrayList<ArrayList<String>> newsItem = new ArrayList<ArrayList<String>>();

    public ConnectRSS(String inputUrl) {

        ArrayList<String> buffer = null;
        try {
            Document doc;
            doc = Jsoup.connect(inputUrl).get();
            item = doc.select("item");
            System.out.println("[+] Connected to " + inputUrl);


            for (Element element : item) {


                buffer = new ArrayList<String>();
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


/*class url {

    String title;
    String description;
    String link;
    String pubdate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubdate() { return pubdate; }

    public void setPubdate(String pubdate) {this.pubdate = pubdate;}

    @Override
    public String toString() {
        return "url [title=" + title + ", description=" + description
                + ", link=" + link + "]";
    }

}

*/

        /*
            Elements links = doc.select("link[type=application/rss+html+xml]");

            while (links.size() > 0) {
                String rss_url = links.get(0).attr("abs:href").toString();
                System.out.println(doc);
            }
        }

    private Elements getTitle() {
        return title;
    }

    private Elements getLink() {
        return link;
    }

    private Elements getDescription() {
        return description;
    }
}

*/