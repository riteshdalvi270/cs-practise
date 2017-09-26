package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

 Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

 * Created by ritesh on 9/20/17.
 */
public class TinyUrl {

    final static Map<Integer, String> urlByHashCode =  new HashMap<>();

    public static void main(String args[]) {

        final String longUrl = "https://leetcode.com/problems/design-tinyurl";

        final String tinyUrl = encode(longUrl);

        System.out.println(tinyUrl);

        System.out.println(decode(tinyUrl));
    }

    public static String encode(String longUrl) {

       String[] baseUrl =  longUrl.split("//");

       String[] url = baseUrl[1].split("/");

       int hashCode = 0;

       for(String ul :  url) {

          hashCode+=getHashCode(ul);
       }

        int positiveHashCode = Math.abs(hashCode);

        urlByHashCode.put(positiveHashCode,longUrl);

       return "http://tinyUrl.com/"+positiveHashCode;
    }

    private static int getHashCode(final String url) {
        return url.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {

        String[] baseUrl =  shortUrl.split("//");

        String[] url = baseUrl[1].split("/");

        String hashCode = url[1];

        return urlByHashCode.get(Integer.valueOf(hashCode));
    }
}
