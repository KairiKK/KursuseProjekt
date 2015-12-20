package RSS_Connect;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Kairi on 19.12.2015.
 *
 * RSS feed connection jsoup abil
 * http://jsoup.org/cookbook/
 */
public class ConnectRSS {

    private Elements title, link, description;

        public static void main(String[] args) throws IOException {

            String url = "http://www.delfi.ee/";
            Document doc = Jsoup.connect(url).get();

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
